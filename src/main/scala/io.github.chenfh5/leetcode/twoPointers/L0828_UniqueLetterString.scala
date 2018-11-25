package io.github.chenfh5.leetcode.twoPointers

object L0828_UniqueLetterString {

  // @see https://leetcode.com/problems/unique-letter-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
  def uniqueLetterString(S: String): Int = {
    var res = 0
    if (S == null || S.length < 1) return res

    val charLastPos, appearAlready = new Array[Int](128) // ascii 0~127
    var curUniqNum = 0
    for (i <- 0 until S.length) {
      val char = S(i)
      curUniqNum -= appearAlready(char)
      appearAlready(char) = i + 1 - charLastPos(char) // new Already
      curUniqNum += appearAlready(char)
      charLastPos(char) = i + 1 // eq cnt. Appear at i, means append to the tail i+1, since the char append all
      res += curUniqNum
    }
    res
  }

  def main(args: Array[String]) {
    val res = uniqueLetterString("ABC")
    print(res)
    assert(res == 10)
  }

}
