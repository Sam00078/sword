package io.github.chenfh5.lc.string


object L0761_SpecialBinaryString {

  def makeLargestSpecial(S: String): String = {
    import scala.collection.mutable.ListBuffer
    val res = ListBuffer[String]()
    var count, i = 0
    for (j <- 0 until S.length) {
      if (S(j) == '1') count += 1 // find largest
      else count -= 1
      if (count == 0) {
        res.append('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0')
        i = j + 1
      }
    }
    res.sortWith(_ > _).mkString("") // `1` in head
  }

  def main(args: Array[String]) {
    val input = "11011000"
    val res = makeLargestSpecial(input)
    print(res)
    assert(res == "11100100")
  }

}
