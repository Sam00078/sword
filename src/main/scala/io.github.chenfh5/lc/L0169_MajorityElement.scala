package io.github.chenfh5.lc

object L0169_MajorityElement {

  /**
    * @see https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
    *      leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution/127325
    */
  def majorityElement(nums: Array[Int]): Int = {
    var (major, count) = (nums.head, 1)
    // major will not be changed once it has been found, since more than n/2 elements are major elements
    for (i <- 1 until nums.length) {
      if (count == 0) {
        count += 1
        major = nums(i)
      } else if (major == nums(i)) count += 1
      else count -= 1
    }
    major
  }

  def main(args: Array[String]) {
    val nums = Array(2, 2, 1, 1, 1, 2, 2)
    val res = majorityElement(nums)
    println(res)
    assert(res == 2)
  }

}
