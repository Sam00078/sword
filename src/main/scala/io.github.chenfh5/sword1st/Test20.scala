package io.github.chenfh5.sword1st

import scala.collection.mutable.ListBuffer


/**
  * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
  */
object Test20 {

  var result = ListBuffer[Int]()

  def printMatrixClockWisely(arr: Array[Array[Int]]): Unit = {
    if (arr == null) return
    var row, col = 0

    while (row * 2 < arr.length && col * 2 < arr.head.length) { //左+右，上+下各往返2次，折返时已经把对面的打印了，所以这里要折半
      printMatrixInCircle(arr, row, col) //打印外围一圈
      row += 1
      col += 1
    }
  }

  def printMatrixInCircle(arr: Array[Array[Int]], row: Int, col: Int): Unit = {
    val (rows, cols) = (arr.length, arr.head.length)

    //left->right
    for (i <- col until cols - col) {
      print(arr(row)(i) + "_")
      result += arr(row)(i)
    }

    //top -> bottom
    for (i <- row + 1 until rows - row) {
      print(arr(i)(cols - col - 1) + "_")
      result += arr(i)(cols - col - 1)
    }

    //right->left
    for (i <- Range.inclusive(cols - col - 1 - 1, col, -1)) {
      print(arr(rows - row - 1)(i) + "_")
      result += arr(rows - row - 1)(i)
    }

    //bottom->top
    for (i <- Range.inclusive(rows - row - 1 - 1, row + 1, -1)) {
      print(arr(i)(col) + "_")
      result += arr(i)(col)
    }
  }

  def main(args: Array[String]): Unit = {
    /*
     *  int[][] matrix = {
             {1, 2, 3, 4, 5},
             {6, 7, 8, 9, 10},
             {11, 12, 13, 14, 15},
             {16, 17, 18, 19, 20}
     };
    */
    val matrix = Array(Array(1, 2, 3, 4, 5), Array(6, 7, 8, 9, 10), Array(11, 12, 13, 14, 15), Array(16, 17, 18, 19, 20))
    printMatrixClockWisely(matrix)
    println()
    println(result.mkString(","))
  }

}
