package io.github.chenfh5.leetcode.array

object L0695_MaxAreaOfIsland {

  // @see https://leetcode.com/problems/max-area-of-island/discuss/108533/JavaC++-Straightforward-dfs-solution/110689
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val (row, col) = (grid.length, grid.head.length)
    var (maxArea, visited) = (0, Array.ofDim[Boolean](row, col)) // default is false
    for (i <- 0 until row) {
      for (j <- 0 until col) {
        if (grid(i)(j) == 1) maxArea = math.max(maxArea, areaOfIsland(grid, i, j, visited))
      }
    }
    maxArea
  }

  def areaOfIsland(grid: Array[Array[Int]], i: Int, j: Int, visited: Array[Array[Boolean]]): Int = {
    if (i >= 0 && i < grid.length && j >= 0 &&
        j < grid.head.length && grid(i)(j) == 1 &&
        !visited(i)(j)) {
      visited(i)(j) = true // prevent modify the raw input
      return 1 + areaOfIsland(grid, i - 1, j, visited) + areaOfIsland(grid, i + 1, j, visited) + areaOfIsland(grid, i, j - 1, visited) + areaOfIsland(grid, i, j + 1, visited) // top, bottom, left, right
    }
    0
  }

  def main(args: Array[String]) {
    val grid = Array(
      Array(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
      Array(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
      Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0))
    val res = maxAreaOfIsland(grid)
    grid.foreach(row => println(row.toList))
    print(res)
    assert(res == 6)
  }

}

