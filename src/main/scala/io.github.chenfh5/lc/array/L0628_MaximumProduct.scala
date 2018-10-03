package io.github.chenfh5.lc.array

object L0628_MaximumProduct {

  def maximumProduct(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 3) throw new IllegalArgumentException("invalid input nums")
    val sortedNums = nums.sortWith(_ < _)
    val len = sortedNums.length
    val s1 = sortedNums(len - 1) * sortedNums(len - 2) * sortedNums(len - 3)
    val s2 = sortedNums(0) * sortedNums(1) * sortedNums(len - 1)
    math.max(s1, s2)
  }

  def main(args: Array[String]) {
    val nums = Array(9, 1, 5, 6, 7, 2)
    val res = maximumProduct(nums)
    println(res)
    assert(res == 378)
  }

}
