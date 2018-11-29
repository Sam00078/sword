package io.github.chenfh5.leetcode.array

object L0565_ArrayNesting {

  // @see https://leetcode.com/problems/array-nesting/discuss/102432/C++-Java-Clean-Code-O(N)
  def arrayNesting(nums: Array[Int]): Int = {
    var maxSize = 0
    for (i <- 0 until nums.length) {
      var curSize = 0
      var nextPos = i
      while (nums(nextPos) >= 0) {
        // swap value and pos
        val numVal = nums(nextPos)
        nums(nextPos) = -1 // disable it
        nextPos = numVal

        curSize += 1
      }
      maxSize = math.max(maxSize, curSize)
    }
    maxSize
  }

  def main(args: Array[String]) {
    val nums = Array(5, 4, 0, 3, 1, 6, 2)
    val res = arrayNesting(nums)
    println(res)
    assert(res == 4)
  }

}
