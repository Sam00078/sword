package io.github.chenfh5.lc.string

object L0696_CountBinarySubstrings {

  // @see https://leetcode.com/problems/count-binary-substrings/discuss/108610/Acceptable-JAVA-solution-with-explaination
  def countBinarySubstrings(s: String): Int = {
    if (s == null || s.length == 0) return 0

    // preRun count the same item happend before
    // curRun count the current number of items
    var (preRun, curRun, res) = (0, 1, 0)
    for (i <- 1 until s.length) {
      if (s(i) == s(i - 1)) curRun += 1
      else {
        preRun = curRun
        curRun = 1
      }
      if (preRun >= curRun) res += 1
    }
    res
  }

  def main(args: Array[String]) {
    val input = "00110"
    val res = countBinarySubstrings(input)
    print(res)
    assert(res == 3)
  }

}
