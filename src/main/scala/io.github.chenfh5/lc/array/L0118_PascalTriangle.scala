package io.github.chenfh5.lc.array

object L0118_PascalTriangle {

  /**
    * @see https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java
    */
  def generate(numRows: Int): List[List[Int]] = {
    import scala.collection.mutable.ListBuffer
    val allRows = ListBuffer[List[Int]]()
    var rowData = ListBuffer[Int]() // in the whole process, only one rowData, but each stop, the rowData would be add and change

    for (i <- 0 until numRows) {
      rowData = ListBuffer(1) ++ rowData // append the previous
      for (j <- 1 until rowData.size - 1) {
        rowData(j) = rowData(j) + rowData(j + 1) // used (current, next) the make current; after that to react the new (current, next)
      }
      allRows.append(rowData.toList) // make rowData of this step
    }
    allRows.toList
  }

  def main(args: Array[String]) {
    val res = generate(5)
    println(res)
    assert(res == List(List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1), List(1, 4, 6, 4, 1)))
  }

}
