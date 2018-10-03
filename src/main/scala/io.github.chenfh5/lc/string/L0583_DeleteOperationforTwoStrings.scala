package io.github.chenfh5.lc.string

object L0583_DeleteOperationforTwoStrings {


  // @see https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)
  def minDistance(word1: String, word2: String): Int = {
    val (len1, len2) = (word1.length, word2.length)
    val dp = Array.ofDim[Int](len1 + 1, len2 + 1) //dp means in pos(i,j), how many common char between two str
    for (i <- 0 to len1) {
      for (j <- 0 to len2) {
        if (i == 0 || j == 0) dp(i)(j) = 0
        else dp(i)(j) = if (word1(i - 1) == word2(j - 1)) dp(i - 1)(j - 1) + 1 else math.max(dp(i - 1)(j), dp(i)(j - 1)) // match then plus one, else choose the biggest
      }
    }
    dp.last.last // Longest Common Subsequence size
    len1 + len2 - 2 * dp.last.last // need how many step to reach LCS
  }

  def main(args: Array[String]) {
    val (word1, word2) = ("sea", "eat")
    val res = minDistance(word1, word2)
    print(res)
    assert(res == 2)
  }

}
