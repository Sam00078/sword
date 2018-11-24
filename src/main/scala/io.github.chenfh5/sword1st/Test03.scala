package io.github.chenfh5.sword1st

/**
  * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
  * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
  */
object Test03 {

  /**
    * 规律：x>number右移，x< number下移
    */
  def find(matrix: Array[Array[Int]], targetNumber: Int): Boolean = {
    if (matrix == null || matrix.length < 1 || matrix.head.length < 1) return false

    val rowSize = matrix.length
    val colSize = matrix.head.length

    var startRow = 0
    var startCol = colSize - 1

    if (targetNumber < matrix.head.head || targetNumber > matrix.last.last) return false

    while (startRow >= 0 && startRow < rowSize && startCol >= 0 && startCol < colSize) {
      if (matrix(startRow)(startCol) == targetNumber) return true
      else if (matrix(startRow)(startCol) > targetNumber) startCol -= 1
      else startRow += 1
    }
    false
  }

  def main(args: Array[String]) {
    /*
    *  int[][] matrix = {
                {1, 2, 8, 9, 10}, //row从左到右递增; col从上到下递增
                {2, 4, 9, 12, 13},
                {4, 7, 10, 13, 14},
                {6, 8, 11, 15, 16}
        };
    * */

    val matrix = Array(Array(1, 2, 8, 9, 10), Array(2, 4, 9, 12, 13), Array(4, 7, 10, 13, 14), Array(6, 8, 11, 15, 16))

    assert(!find(matrix, 5))
    assert(find(matrix, 11))
    assert(find(matrix, 13))
  }

}
