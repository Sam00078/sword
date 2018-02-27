package io.github.chenfh5.collection

/**
  * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
  * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
  * 求数组的连续子数组之和的最大值。
  */
object Test31 {

  //试探法
  def findMaxSumOfSubArray(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input size")

    var maxSum = Int.MinValue //最大的子数组和
    var curMaxSum = 0 //当前的和

    for (i <- arr) {
      if (curMaxSum <= 0) curMaxSum = i //如果当前和小于等于0，就重置当前和
      else curMaxSum += i //如果当前和大于0，累加当前和

      if (maxSum < curMaxSum) maxSum = curMaxSum //更新记录到的最在的子数组和
    }
    maxSum
  }

  def main(args: Array[String]): Unit = {
    val input = Array(1, -2, 3, 10, -4, 7, 2, -5)
    assert(findMaxSumOfSubArray(input) == 18) //3, 10, -4, 7
  }

}
