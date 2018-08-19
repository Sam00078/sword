package io.github.chenfh5.lc.binarySearch

object L0300_LengthOfLIS {

  // @see https://leetcode.com/problems/longest-increasing-subsequence/discuss/74953/Java-solution-dp-simple
  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 1) return 0
    val dp = new Array[Int](nums.length)
    var max = 1
    for (right <- 0 until nums.length) {
      dp(right) = 1 // one element at least
      for (left <- 0 until right) {
        if (nums(left) < nums(right)) {
          // find before is match
          dp(right) = math.max(dp(right), dp(left) + 1)
          max = math.max(max, dp(right))
        }
      }
    }
    max
  }

  def main(args: Array[String]) {
    val nums = Array(10, 9, 2, 5, 3, 6, 7, 101, 18)
    val res = lengthOfLIS(nums)
    print(res)
  }

}
