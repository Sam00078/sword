package io.github.chenfh5.lc.array

object L0034_SearchRange {

  /**
    * @see https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution
    */
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val left = findBound(nums, target, isFindLeft = true)
    val right = if (left > -1) findBound(nums, target, isFindLeft = false) else -1
    Array(left, right)
  }

  def findBound(nums: Array[Int], target: Int, isFindLeft: Boolean): Int = {
    // nums is in ascending
    var pos = -1
    var (low, high) = (0, nums.length - 1)
    while (low <= high) {
      val mid = (low + high) / 2
      if (isFindLeft) {
        if (nums(mid) >= target) high = mid - 1 //eq target also need to minus, to find the left
        else low = mid + 1
      } else {
        if (nums(mid) > target) high = mid - 1
        else low = mid + 1 // eq target also need to add, find the right
      }
      if (nums(mid) == target) pos = mid
    }
    pos
  }

  def main(args: Array[String]) {
    val nums = Array(5, 7, 7, 8, 8, 10)
    val res = searchRange(nums, 8)
    println(res.toList)
    assert(res sameElements Array(3, 4))
  }

}
