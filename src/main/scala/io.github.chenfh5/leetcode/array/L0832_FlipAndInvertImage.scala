package io.github.chenfh5.leetcode.array

object L0832_FlipAndInvertImage {

  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
    val (row, col) = (A.length, A.head.length)
    for (i <- 0 until row) {
      flipHorizontally(A(i)) // flip horizontally could independence
      for (j <- 0 until col) {
        if (A(i)(j) == 0) A(i)(j) = 1 // invert
        else A(i)(j) = 0 // 0 <= A[i][j] <= 1
      }
    }
    A
  }

  def flipHorizontally(nums: Array[Int]): Unit = {
    val len = nums.length
    // len/2, not len, otherwise swap too many
    // 1,2,3 -> swapCnt=1. 1,2,3,4 -> swapCnt=2
    for (i <- 0 until len / 2) {
      swap(nums, i, len - 1 - i)
    }
  }

  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }

  // @see https://leetcode.com/submissions/detail/168979480/
  // so many awesome ans
  def flipAndInvertImage2(A: Array[Array[Int]]): Array[Array[Int]] = {
    A.map { row =>
      row.reverse.map {
        case 0 => 1
        case 1 => 0
      }
    }
  }

  def main(args: Array[String]) {
    val A = Array(Array(1, 1, 0, 0), Array(1, 0, 0, 1), Array(0, 1, 1, 1), Array(1, 0, 1, 0))
    A.foreach(arr => println(arr.toList))
    val res = flipAndInvertImage(A)
    println()
    res.foreach(arr => println(arr.toList))
  }

}
