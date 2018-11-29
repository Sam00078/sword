package io.github.chenfh5.leetcode.array

object L0665_NonDecreasingArray {

  // @see http://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC++-Simple-greedy-like-solution-with-explanation
  def checkPossibility(nums: Array[Int]): Boolean = {
    var count = 0
    for (i <- 1 until nums.length if count <= 1) {
      if (nums(i - 1) > nums(i)) {
        count += 1
        if (i - 2 < 0 || nums(i - 2) <= nums(i)) nums(i - 1) = nums(i) // 后面的覆盖上来. 2,4,3 -> 2,3,3. not 2,4,4
        else nums(i) = nums(i - 1) // 前面的覆盖下去. 3,4,2 -> 3,4,4. not 3,2,2
      }
    }
    count <= 1
  }

  def main(args: Array[String]) {
    val nums = Array(4, 2, 3)
    val res = checkPossibility(nums)
    print(res)
    assert(res)
  }

}
