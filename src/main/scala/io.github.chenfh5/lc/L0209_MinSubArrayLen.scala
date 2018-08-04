package io.github.chenfh5.lc

object L0209_MinSubArrayLen {

  /**
    * @see https://leetcode.com/submissions/detail/167535432/
    *      https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
    */
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    nums match {
      case _ if nums == null || nums.length < 1 => 0
      case _ =>
        var (leftMost, curSum, minLen) = (0, 0, Int.MaxValue)
        // always add the new/right to curSum, if the curSum(after append) gt target, then attempt to minus the left-most
        for (i <- 0 until nums.length) {
          curSum += nums(i) // add

          while (curSum >= s) {
            minLen = math.min(minLen, i + 1 - leftMost)
            curSum -= nums(leftMost) // attempt minus the left-most
            leftMost += 1
          }
        }
        if (minLen == Int.MaxValue) 0 else minLen
    }
  }

  def main(args: Array[String]) {
    val nums = Array(2, 3, 1, 2, 4, 3)
    val res = minSubArrayLen(7, nums)
    assert(res == 2)
  }

}
