package io.github.chenfh5.lc.array


object L0830_LargeGroupPositions {

  def largeGroupPositionsOwn(S: String): List[List[Int]] = {
    import scala.collection.mutable.ListBuffer
    val len = S.length
    val res = ListBuffer[List[Int]]()

    var i = 0
    while (i < S.length - 2) {
      if (S(i + 2) == S(i)) {
        var (begin, end) = (i, i + 2)
        while (end < S.length - 1 && S(end) == S(end + 1)) end += 1
        res += List[Int](begin, end)
        i = end + 1 // next loop
      } else i += 1
    }
    res.toList
  }

  // @see https://leetcode.com/problems/positions-of-large-groups/discuss/128961/Java-Solution-Two-Pointers
  def largeGroupPositions(S: String): List[List[Int]] = {
    import scala.collection.mutable.ListBuffer
    val len = S.length
    val res = ListBuffer[List[Int]]()

    var start = 0
    for (i <- 1 to len) {
      if (i == len || S(i) != S(start)) {
        // check if not equal, and then check the same char size
        if (i - start >= 3) res += List[Int](start, i - 1) // S(i) is not consecutive with the ahead elements, so drop the it
        start = i
      }
    }
    res.toList
  }

  def main(args: Array[String]) {
    val s = "abcdddeeeeaabbbcdxxxx"
    val res = largeGroupPositions(s)
    print(res)
    val expect = List(List(3, 5), List(6, 9), List(12, 14), List(17, 20))
    assert(res == expect)
  }

}
