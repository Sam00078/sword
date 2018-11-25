package io.github.chenfh5.leetcode.array

object L0643_FindMaxAverage {

  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    if (nums == null || nums.length < k) throw new IllegalArgumentException("invalid input nums")
    var curSum = 0
    for (i <- 0 until k) curSum += nums(i)
    var maxSum = curSum

    for (i <- k until nums.length) {
      curSum += nums(i) - nums(i - k) // curSum is change every loop
      maxSum = math.max(maxSum, curSum) // maxSum only change when hit
    }
    maxSum.toDouble / k
  }

  def main(args: Array[String]) {
    val nums = Array(7, 4, 5, 8, 8, 3, 9, 8, 7, 6)
    val res = findMaxAverage(nums, 7)
    println(res)
    assert(res == 7.0)
  }

}
