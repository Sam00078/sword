package io.github.chenfh5.leetcode.array

object L0189_RotateArray {

  /**
    * @see https://leetcode.com/submissions/detail/167532194/
    *      https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
    */
  def rotate(nums: Array[Int], k: Int): Unit = {
    nums match {
      case _ if nums == null || nums.length < 1 =>
      case _ =>
        val k2 = k % nums.length
        val rotatedNums = nums.takeRight(k2) ++ nums.dropRight(k2) // extra space O(n)
        rotatedNums.indices.foreach(i => nums(i) = rotatedNums(i))
    }
  }

  def rotate2(nums: Array[Int], k: Int): Unit = {
    val len = nums.length
    val kk = k % len // 3 % 7 = 3

    // Two negatives make a positive
    reverse(nums, 0, len - 1) // reverse the whole
    reverse(nums, 0, kk - 1) // reverse the left part
    reverse(nums, kk, len - 1) // reverse the right part
  }

  def reverse(nums: Array[Int], start: Int, end: Int): Unit = {
    var (startVar, endVar) = (start, end)
    while (startVar < endVar) {
      val temp = nums(startVar)
      nums(startVar) = nums(endVar)
      nums(endVar) = temp
      startVar += 1
      endVar -= 1
    }
  }

  def main(args: Array[String]) {
    val nums = Array(1, 2, 3, 4, 5, 6, 7)
    rotate(nums, 3)
    println(nums.toList)
    assert(nums sameElements Array(5, 6, 7, 1, 2, 3, 4))
  }

}
