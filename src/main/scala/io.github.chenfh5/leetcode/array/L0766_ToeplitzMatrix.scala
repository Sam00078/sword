package io.github.chenfh5.leetcode.array

object L0766_ToeplitzMatrix {

  // @see https://leetcode.com/problems/toeplitz-matrix/discuss/113417/Java-solution-4-liner.
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    if (matrix == null || matrix.length < 1 || matrix.head.length < 1) return false

    for (i <- 0 until matrix.length - 1) {
      for (j <- 0 until matrix.head.length - 1) {
        if (matrix(i)(j) != matrix(i + 1)(j + 1)) return false
      }
    }
    true
  }

  def main(args: Array[String]) {
    val matrix = Array(Array(1, 2, 3, 4), Array(5, 1, 2, 3), Array(9, 5, 1, 2))
    val res = isToeplitzMatrix(matrix)
    print(res)
    assert(res)
  }

}
