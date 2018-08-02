package io.github.chenfh5.lc

object SpiralOrder_54 {

  /**
    * @see https://leetcode.com/problems/spiral-matrix/discuss/20570/Clean-Java-readable-human-friendly-code
    */
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    import scala.collection.mutable.ListBuffer
    val res = ListBuffer[Int]()
    if (matrix == null || matrix.length < 1 || matrix.head.length < 1) return res.toList

    var (top, right, bottom, left) = (0, matrix.head.length - 1, matrix.length - 1, 0) // clockwise
    var done = false
    while (!done) {
      // left -> right
      for (i <- Range(left, right).inclusive) res += matrix(top)(i)
      top += 1
      done = isDone(top, right, bottom, left)

      // top -> bottom
      if (!done) {
        for (i <- Range(top, bottom).inclusive) res += matrix(i)(right) // since the upper level have add/minus 1, therefore inclusive
        right -= 1
        done = isDone(top, right, bottom, left)
      }

      // right -> left
      if (!done) {
        for (i <- Range(right, left, -1).inclusive) res += matrix(bottom)(i)
        bottom -= 1
        done = isDone(top, right, bottom, left)
      }

      // bottom -> top
      if (!done) {
        for (i <- Range(bottom, top, -1).inclusive) res += matrix(i)(left)
        left += 1
        done = isDone(top, right, bottom, left)
      }
    }
    res.toList
  }

  def isDone(top: Int, right: Int, bottom: Int, left: Int): Boolean = {
    if (left > right || top > bottom) true
    else false
  }

  def main(args: Array[String]) {
    val matrix = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12))
    val res = spiralOrder(matrix)
    println(res)
    assert(res == List(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))

  }

}
