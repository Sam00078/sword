package io.github.chenfh5.lc

object L0031_NextPermutation {

  /**
    * @see https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution
    *      original = 6 5 4 8 7 5 1
    */
  def nextPermutation(nums: Array[Int]): Unit = {
    if (nums == null || nums.length < 2) return
    var i = nums.length - 2
    // step 1: find the first element whose value is lte(not lt) the latter from right to left
    while (i >= 0 && nums(i) >= nums(i + 1)) i -= 1
    if (i >= 0) {
      // i is found
      var j = nums.length - 1
      val target = nums(i)
      while (target >= nums(j)) j -= 1 // find the first element whose value is gte(not gt) than target from right to left, then j not minus
      swap(nums, i, j) // 6 5 `5 8 7 `4 1, i = 2, j = 5
    }
    // since step 1 find the first value in breaking order, those the i+1~length-1 are in the same order(desc)
    reverseOrder(nums, i + 1)
  }


  // reverse the order which have already order before
  def reverseOrder(nums: Array[Int], startPos: Int): Unit = {
    var (i, j) = (startPos, nums.length - 1)
    while (i < j) {
      swap(nums, i, j)
      i += 1
      j -= 1
    }
  }

  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }

  def main(args: Array[String]) {
    val nums = Array(6, 5, 4, 8, 7, 5, 1)
    nextPermutation(nums)
    println(nums.toList)
    //    assert(nums sameElements Array(6, 5, 5, 1, 4, 7, 8))
  }

}
