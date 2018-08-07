package io.github.chenfh5.lc.array

object L0565_ArrayNesting {

  /**
    * @see https://leetcode.com/problems/array-nesting/discuss/102432/C++-Java-Clean-Code-O(N)
    */
  def arrayNesting(nums: Array[Int]): Int = {
    var maxSize = 0
    for (i <- 0 until nums.length) {
      var curSize = 0
      var nestPos = i
      while (nums(nestPos) >= 0) {
        // swap value and pos
        val numVal = nums(nestPos)
        nums(nestPos) = -1
        nestPos = numVal

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
