package io.github.chenfh5.lc.array

object L0661_ImageSmoother {

  /**
    * @see leetcode.com/problems/image-smoother/discuss/106602/Very-Clean-Solution-in-Java/114998
    */
  def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
    if (M == null || M.length < 1 || M.head.length < 1) return M
    val (row, col) = (M.length, M.head.length)
    val res = Array.ofDim[Int](row, col)

    for (i <- 0 until row) {
      for (j <- 0 until col) {
        res(i)(j) = smooth(M, i, j)
      }
    }
    res
  }

  @inline
  def smooth(M: Array[Array[Int]], x: Int, y: Int): Int = {
    val (row, col) = (M.length, M.head.length)
    var (sum, count) = (0, 0)

    for (i <- -1 to 1) {
      // -1 is left, 0 is mid, 1 is right
      for (j <- -1 to 1) {
        // out of boundary, so skip
        if (x + i < 0 || x + i >= row ||
            y + j < 0 || y + j >= col) None
        else {
          count += 1
          sum += M(x + i)(y + j)
        }
      }
    }
    sum / count
  }

  def main(args: Array[String]) {
    val M = Array(Array(1, 1, 1), Array(1, 0, 1), Array(1, 1, 1))
    val res = imageSmoother(M)
    res.foreach(row => print(row.toList))
    val assertM = Array(Array(0, 0, 0), Array(0, 0, 0), Array(0, 0, 0))
    for (i <- res.indices) {
      assert(res(i) sameElements assertM(i))
    }
  }

}
