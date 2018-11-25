package io.github.chenfh5.leetcode.array

object L0026_RemoveDuplicates {

  // with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    var uniqueSize = 0
    for (i <- 1 until nums.length) {
      if (nums(i) != nums(uniqueSize)) {
        // replace with uniqueSize when not equal to the next element
        uniqueSize += 1
        nums(uniqueSize) = nums(i) // no swap, just replace directly
      }
    }
    uniqueSize += 1
    println(nums.toList)
    uniqueSize
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    assert(removeDuplicates(nums) == 5) //0, 1, 2, 3, 4, ...
  }

}
