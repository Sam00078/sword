package io.github.chenfh5.lc.string

object L0522_LongestUncommonSubsequence {

  // @see https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/144926/JAVA-13-lines-5ms-beats-100-with-explaination
  // @see https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/130242/Java-Intuitive-Code-with-Explanations
  def findLUSlength(strs: Array[String]): Int = {
    var res = -1
    var continue = true
    for (i <- 0 until strs.length) {
      continue = true
      if (strs(i).length < res) continue = false
      if (continue) {
        var j = 0
        var done = false
        while (j < strs.length && !done) {
          if (i != j && isSubsequence(strs(i), strs(j))) done = true // jump then is sub
          if (!done) j += 1 // do not add when is sub
        }
        if (j == strs.length) res = math.max(res, strs(i).length)
      }
    }
    res
  }

  /**
    * s1=ac
    * s2=abc
    *
    * @return true if s1 is the subsequence of s2
    */
  def isSubsequence(s1: String, s2: String): Boolean = {
    var i, j = 0
    while (i < s1.length && j < s2.length) {
      if (s1(i) == s2(j)) i += 1
      j += 1
    }
    i == s1.length
  }

  def main(args: Array[String]) {
    val input = Array("aba", "cdc", "eae")
    val res = findLUSlength(input)
    println(res)
    assert(isSubsequence("ac", "abc")) // s1 is the subseq of abc
    assert(res == 3)
  }

}
