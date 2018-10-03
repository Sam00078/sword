package io.github.chenfh5.lc.array

object L0283_MoveZeroes {

  /**
    * @see https://leetcode.com/problems/move-zeroes/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index
    */
  def moveZeroes(nums: Array[Int]): Unit = {
    var zeroPos = 0
    for (i <- 0 until nums.length) {
      // if noo-zero swap itself
      if (nums(i) != 0) {
        if (nums(zeroPos) == 0) {
          nums(zeroPos) = nums(i)
          nums(i) = 0
        }
        zeroPos += 1
      }
    }
  }

  @inline
  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }

  def main(args: Array[String]) {
    val nums = Array(0, 2, 1, 0, 3, 12)
    moveZeroes(nums)
    println(nums.toList)
    assert(nums sameElements Array(2, 1, 3, 12, 0, 0))
  }

}
