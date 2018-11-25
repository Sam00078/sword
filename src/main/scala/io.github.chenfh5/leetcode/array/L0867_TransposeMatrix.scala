package io.github.chenfh5.leetcode.array

object L0867_TransposeMatrix {

  // @see https://leetcode.com/problems/transpose-matrix/discuss/158312/Simple-JAVA-Solution
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val (row, col) = (A.length, A.head.length)
    val res = Array.ofDim[Int](col, row)
    for (i <- 0 until row) {
      for (j <- 0 until col) {
        res(j)(i) = A(i)(j)
      }
    }
    res
  }

  def main(args: Array[String]) {
    val A = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = transpose(A)
    res.foreach(arr => println(arr.toList))
    val expect = Array(Array(1, 4), Array(2, 5), Array(3, 6))
    for (i <- 0 until res.length) {
      assert(res(i) sameElements expect(i))
    }
  }

}
