package io.github.chenfh5.leetcode.string


object L0916_WordSubsets {

  // @see https://leetcode.com/problems/word-subsets/discuss/175854/C++JavaPython-Straight-Forward
  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    val unique = new Array[Int](26)
    var freq = Array[Int]()
    for (bStr <- B) {
      freq = counter(bStr)
      for (i <- 0 until 26) unique(i) = math.max(unique(i), freq(i)) // most freq letter have covered the other letter occurrence
    }
    import scala.collection.mutable
    val res = mutable.ListBuffer[String]()
    for (aStr <- A) {
      freq = counter(aStr)
      var (loopCnt, done) = (0, false) // reset
      while (loopCnt < 26 && !done) {
        if (freq(loopCnt) < unique(loopCnt)) done = true // a < b, fail
        if (!done) loopCnt += 1
      }
      if (loopCnt == 26) res.append(aStr) // iterator all 26 letters, and the cnt of one a is ge all b
    }
    res.toList
  }

  // count the letter frequency of string s
  def counter(s: String): Array[Int] = {
    val count = new Array[Int](26)
    for (c <- s) count(c - 'a') += 1
    count
  }

  def main(args: Array[String]) {
    val A = Array("amazon", "apple", "facebook", "google", "leetcode")
    val B = Array("ec", "oc", "ceo")
    val res = wordSubsets(A, B)
    val expect = List("facebook", "leetcode")
    println(res)
    assert(res == expect)
  }

}
