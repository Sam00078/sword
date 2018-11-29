package io.github.chenfh5.leetcode.array

object L0561_ArrayPairSum {

  // @see https://blog.csdn.net/mine_soul/article/details/70652353
  def arrayPairSum(nums: Array[Int]): Int = {
    val sortNums = nums.sortWith(_ < _)
    var res = 0
    for (i <- Range(0, sortNums.length, 2)) {
      res += sortNums(i)
    }
    res
  }

  def main(args: Array[String]) {
    val nums = Array(1, 4, 3, 2)
    val res = arrayPairSum(nums)
    println(res)
    assert(res == 4)
  }

}
