package io.github.chenfh5.other

/**
  * 复杂度为o(nlogn)
  * 给定一个数组，里面的数字有正有负。求该数组中`和的绝对值`最小的连续子数组。
  * 例：
  * 1 3 -2 -5 1 6 7
  * 答案为 0， 子数组为 【-2 -5 1 6】
  */
object MsTest02 {

  /**
    * @see http://blog.csdn.net/sunset108/article/details/40985129
    *      http://www.voidcn.com/article/p-mirpmupt-bnu.html
    *      http://blog.csdn.net/zuijinhaoma8/article/details/45290145
    */
  def minAbsSubArray(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")

    var curSum = 0
    val sumArr = new Array[Int](arr.length)

    for (i <- arr.indices) {
      curSum += arr(i)
      if (curSum == 0) return 0
      else sumArr(i) = curSum //b(n) = a(1)+a(2)+...+a(n)
    }

    /**
      * Δb = b(n+i)-b(n) = a(n+i) + a(n+i-1) +...+ a(n+1)
      * n=2,i=3, b(5)-b(2) = a(5) + a(4) + a(3)
      * 排序后求`相差的段(j-i)`
      */
    val sortSumArr = sumArr.sortWith(_ < _)

    var minSumAbs = math.abs(sortSumArr(1) - sortSumArr(0))
    for (i <- 1 until sortSumArr.length - 1) {
      curSum = math.abs(sortSumArr(i + 1) - sortSumArr(i))
      if (curSum < minSumAbs) minSumAbs = curSum
    }
    minSumAbs
  }

  def main(args: Array[String]): Unit = {
    val input = Array(1, 3, -2, -5, 1, 6, 7)
    assert(minAbsSubArray(input) == 0)
  }

}
