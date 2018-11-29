package io.github.chenfh5.leetcode.array

object L0674_FindLengthOfLCIS {

  // @see https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107365/JavaC++Clean-solution
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    var (res, count) = (0, 0)
    for (i <- 0 until nums.length) {
      // here is continuous
      if (i == 0 || nums(i - 1) < nums(i)) {
        count += 1
        res = math.max(res, count)
      }
      else count = 1
    }
    res
  }

  def main(args: Array[String]) {
    val nums = Array(1, 3, 5, 4, 7)
    val res = findLengthOfLCIS(nums)
    print(res)
    assert(res == 3)
  }

}
