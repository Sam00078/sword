package io.github.chenfh5.leetcode.binarySearch

object L0240_SearchMatrix2 {

  // @see https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m+n)-Java-solution
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    matrix match {
      case _ if matrix == null || matrix.length < 1 || matrix.head.length < 1 => false
      case _ =>
        var (curRow, curCol) = (0, matrix.head.length - 1) // initialize from top right corner
        while (curRow < matrix.length && curCol >= 0) {
          val curVal = matrix(curRow)(curCol)
          if (curVal == target) return true
          else if (curVal > target) curCol -= 1 // move to left
          else curRow += 1 // move to bottom
        }
        false
    }
  }

  def main(args: Array[String]) {
    val matrix = Array(
      Array(1, 4, 7, 11, 15),
      Array(2, 5, 8, 12, 19),
      Array(3, 6, 9, 16, 22),
      Array(10, 13, 14, 17, 24),
      Array(18, 21, 23, 26, 30))
    val res = searchMatrix(matrix, 5)
    print(res)
    assert(res)
  }

}
