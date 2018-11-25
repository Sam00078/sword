package io.github.chenfh5.leetcode.array

object L0840_NumMagicSquaresInside {

  // @see https://leetcode.com/problems/magic-squares-in-grid/discuss/133938/Java-8-ms-Straightforward-and-Ugly-Solution/152505
  def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
    val (row, col) = (grid.length, grid.head.length)
    var res = 0
    for (i <- 0 until row - 2) {
      // if row = 5, i=(0,1,2)
      for (j <- 0 until col - 2) {
        if (isMagic(grid, i, j)) res += 1
      }
    }
    res
  }

  @inline
  def isMagic(grid: Array[Array[Int]], i: Int, j: Int): Boolean = {
    // diagonals
    val (diagonalSum, antiDiagonalSum) = (
        grid(i)(j) + grid(i + 1)(j + 1) + grid(i + 2)(j + 2), // top-left to bottom-right
        grid(i)(j + 2) + grid(i + 1)(j + 1) + grid(i + 2)(j)) // top-right to bottom-left
    if (diagonalSum != antiDiagonalSum) return false
    // rows and cols
    for (k <- 0 until 3) {
      val (rowSum, colSum) = (
          grid(i + k)(j) + grid(i + k)(j + 1) + grid(i + k)(j + 2),
          grid(i)(j + k) + grid(i + 1)(j + k) + grid(i + 2)(j + k))
      if (rowSum != colSum) return false
    }
    // magic grid filled with distinct numbers from 1 to 9 (3 x 3)
    val set = scala.collection.mutable.Set(Range(1, 9).inclusive: _*) // val set = Set(1 to 9: _*)
    for (ii <- 0 until 3) {
      for (jj <- 0 until 3) {
        if (!set.remove(grid(i + ii)(j + jj))) return false
      }
    }
    // return
    true
  }

  def main(args: Array[String]) {
    val grid = Array(Array(4, 3, 8, 4), Array(9, 5, 1, 9), Array(2, 7, 6, 2))
    val res = numMagicSquaresInside(grid)
    print(res)
    assert(res == 1)
  }

}
