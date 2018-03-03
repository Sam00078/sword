package io.github.chenfh5.other

object NQueen {

  private var queenColNum = 0
  private var result: Array[Int] = _

  /**
    * @see http://blog.csdn.net/tianyaleixiaowu/article/details/50945054
    */
  def initial(queenNum: Int = 8) = {
    this.queenColNum = queenNum //一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
    result = new Array[Int](queenNum)
    check(0)
  }

  //queenIndex代表当前是第几个皇后
  def check(queenRowIndex: Int): Unit = {
    if (queenRowIndex == queenColNum) {
      //终止条件是最后一行已经摆完,进来后是(queenIndex+1)了.
      dumpQueen()
      return
    }

    //从第一列开始放值，然后判断是否和`本行`本列`本斜线`是否有冲突
    for (col <- 0 until queenColNum) {
      result(queenRowIndex) = col
      if (valid(queenRowIndex)) check(queenRowIndex + 1) //如果OK，就进入下一行的逻辑
    }
  }

  def valid(queenRowIndex: Int): Boolean = {
    for (row <- 0 until queenRowIndex) {
      if (result(row) == result(queenRowIndex) || //同列
          math.abs(queenRowIndex - row) == math.abs(result(queenRowIndex) - result(row))) return false //同斜率
    }
    true
  }

  def dumpQueen(): Unit = {
    for (i <- result) {
      print(i + 1 + " ")
    }
    println()
  }

  def main(args: Array[String]) {
    initial(4)
    println()
    initial(8)
  }

}
