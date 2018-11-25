package io.github.chenfh5.leetcode.array

object L0064_MinPathSum {

  /**
    * @see https://leetcode.com/problems/minimum-path-sum/discuss/23647/My-8-lines-simple-solution
    */
  def minPathSum(grid: Array[Array[Int]]): Int = {
    if (grid == null || grid.length < 1 || grid.head.length < 1) return 0

    // row
    for (i <- 0 until grid.length) {
      // column
      for (j <- 0 until grid.head.length) {
        // accumulate the min sum as one grid
        if (i == 0 && j != 0) grid(i)(j) += grid(i)(j - 1) //first row, DP
        if (i != 0 && j == 0) grid(i)(j) += grid(i - 1)(j) // first column
        if (i != 0 && j != 0) grid(i)(j) += math.min(grid(i)(j - 1), grid(i - 1)(j)) // 1,2 -> 1,1 or 0,2 @ 1,1 -> 0,1 or 1,0
      }
    }
    grid.last.last
  }

  def main(args: Array[String]) {
    val grid = Array(Array(1, 3, 1), Array(1, 5, 1), Array(4, 2, 1))
    val res = minPathSum(grid)
    println(res)
    assert(res == 7)
  }

}
