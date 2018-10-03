package io.github.chenfh5.lc.array

object L0689_MaxSumOfThreeSubarrays {

  // @see https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108231/C++Java-DP-with-explanation-O(n)
  // TODO
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    null
  }

  def main(args: Array[String]) {
    val nums = Array(1, 2, 1, 2, 6, 7, 5, 1)
    val res = maxSumOfThreeSubarrays(nums, 2)
    val assertNums = Array(0, 3, 5)
    for (i <- res.indices) {
      assert(res(i) == assertNums(i))
    }
  }

}
