package io.github.chenfh5.leetcode.array

object L0747_LargestTwiceOfOthers {

  // @see https://leetcode.com/problems/largest-number-at-least-twice-of-others/discuss/152120/One-Pass-O(N)-Java-Solution-9ms-100
  def dominantIndex(nums: Array[Int]): Int = {
    var (secondMax, max, maxPos) = (-1, -1, -1)
    for (i <- 0 until nums.length) {
      if (nums(i) > max) {
        secondMax = max // put the older max to secondMax
        max = nums(i)
        maxPos = i
      } else if (nums(i) > secondMax) {
        secondMax = nums(i)
      }
    }
    if (max >= secondMax * 2) maxPos else -1
  }

  def main(args: Array[String]) {
    val nums = Array(0, 0, 2, 3)
    val res = dominantIndex(nums)
    print(res)
    assert(res == -1)
  }

}
