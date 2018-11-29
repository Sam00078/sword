package io.github.chenfh5.leetcode.array

object L0566_MatrixReshape {

  // @see https://leetcode.com/problems/reshape-the-matrix/discuss/102491/Java-Concise-O(nm)-time
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    val (row, col) = (nums.length, nums.head.length)
    if (row * col != r * c) return nums

    val matrix = Array.ofDim[Int](r, c)
    for (i <- 0 until r * c) {
      matrix(i / c)(i % c) = nums(i / col)(i % col) //[4,4] -> [2,8] -> if i=5,5/8=0. if i=9,9/8=1
    }
    matrix
  }

  def main(args: Array[String]) {
    val nums = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12))
    val res = matrixReshape(nums, 4, 3)
    res.foreach(row => println(row.toList))
    val assertNums = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9), Array(10, 11, 12))
    for (i <- res.indices) {
      assert(res(i) sameElements assertNums(i))
    }
  }

}
