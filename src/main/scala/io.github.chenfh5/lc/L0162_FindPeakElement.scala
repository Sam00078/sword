package io.github.chenfh5.lc

object L0162_FindPeakElement {

  /**
    * @see https://leetcode.com/problems/find-peak-element/discuss/50239/Java-solution-and-explanation-using-invariants
    *      local peak number
    */
  def findPeakElement(nums: Array[Int]): Int = {
    var (left, mid, right) = (0, 0, nums.length - 1)
    while (left < right) {
      mid = (left + right) / 2
      // nums[left - 1] < nums[left] && nums[right] > nums[right + 1]
      if (nums(mid) < nums(mid + 1)) left = mid + 1 // if true, then only right part would be possible, so left++
      else right = mid // if left > right, then only left part would be possible, so right--
    }
    left
  }

  def main(args: Array[String]) {
    val nums = Array(1, 2, 1, 3, 5, 6, 4)
    val res = findPeakElement(nums)
    println(res)
    assert(Set(1, 5).contains(res))
  }

}
