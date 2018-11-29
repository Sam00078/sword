package io.github.chenfh5.leetcode.array

object L0128_LongestConsecutiveSeq {

  // @see https://leetcode.com/submissions/detail/167517079/
  def longestConsecutive(nums: Array[Int]): Int = {
    var (set, maxLen) = (nums.toSet, 0)
    for (oneNum <- nums) {
      if (!set.contains(oneNum - 1)) {
        // find the min left
        var right = oneNum + 1
        while (set.contains(right)) right += 1 // find the max right
        maxLen = Math.max(maxLen, right - oneNum)
      }
    }
    maxLen
  }

  def main(args: Array[String]) {
    val nums = Array(100, 4, 200, 1, 3, 2)
    val res = longestConsecutive(nums)
    println(res)
    assert(res == 4)
  }

}
