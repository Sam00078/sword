package io.github.chenfh5.collection

/**
  * 输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素.
  */
object Test08 {

  def findMin(numbers: Array[Int]): Int = {
    if (numbers == null || numbers.length == 0) throw new RuntimeException("this is the invalid input number")

    var low = 0
    var high = numbers.length - 1

    var mid = low
    while (numbers(low) >= numbers(high)) {
      if (high - low == 1) return numbers(high) //只剩下2个，右侧更小

      /*二分查找*/
      mid = (low + high) / 2

      /*corner case*/
      if (numbers(low) == numbers(mid) == numbers(high)) return numbers.slice(low, high).min

      if (numbers(low) < numbers(mid)) low = mid //45123，45623
      else high = mid
    }

    numbers(mid)
  }

  def main(args: Array[String]): Unit = {
    val input = Array(3, 4, 5, 1, 2)

    assert(findMin(input) == 1)

  }

}
