package io.github.chenfh5.leetcode.array

object L0719_SmallestDistancePair {

  // @see https://leetcode.com/problems/find-k-th-smallest-pair-distance/solution/
  def smallestDistancePair(nums: Array[Int], k: Int): Int = {
    val sortedNums = nums.sortWith(_ < _)
    // not sure midDiff is num(1)-num(0), since num(2)-num(1) would be possible. like 1,3,4. but the maxDiff can be sure
    var (minDiff, maxDiff) = (0, sortedNums.last - sortedNums.head)
    while (minDiff < maxDiff) {
      var (midDiff, count, left) = ((minDiff + maxDiff) / 2, 0, 0)
      for (right <- 0 until sortedNums.length) {
        // use midDiff to get rid of unused
        while (sortedNums(right) - sortedNums(left) > midDiff) left += 1
        count += right - left
      }
      // k-th smallest
      if (count >= k) maxDiff = midDiff
      else minDiff = midDiff + 1
    }
    minDiff // k-th smallest and its diff value
  }

  def main(args: Array[String]) {
    val nums = Array(62, 100, 4)
    val res = smallestDistancePair(nums, 2)
    print(res)
    assert(res == 58)
  }

}
