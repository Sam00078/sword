package io.github.chenfh5.lc.string

object L0097_InterleavingString {

  // @see https://leetcode.com/problems/interleaving-string/discuss/31879/My-DP-solution-in-C++/30684
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    if (s1.length + s2.length != s3.length) return false

    val (row, col) = (s1.length, s2.length)
    val dp = Array.ofDim[Boolean](row + 1, col + 1) // the above is match or not
    for (i <- 0 to row) {
      for (j <- 0 to col) {
        if (i == 0 && j == 0) dp(0)(0) = true
        else if (j == 0) dp(i)(j) = dp(i - 1)(j) && (s1(i - 1) == s3(i - 1 + j)) // initialize first col. cat not from (j-1=-1). i.e., previous col, since no previous col already(top->bottom only)
        else if (i == 0) dp(i)(j) = dp(i)(j - 1) && (s2(j - 1) == s3(j - 1 + i)) // initialize first row. cat not from (i-1=-1). i.e., previous row
        else {
          dp(i)(j) =
              (dp(i - 1)(j) && (s1(i - 1) == s3(i - 1 + j))) || // from (i-1)(j), from previous row. why add j, since it from j means have already move j step
                  (dp(i)(j - 1) && (s2(j - 1) == s3(j - 1 + i))) // from (i)(j-1), from previous col
        }
      }
    }
    dp.last.last
  }

  def main(args: Array[String]) {
    val (s1, s2, s3) = ("aabcc", "dbbca", "aadbbcbcac")
    val res = isInterleave(s1, s2, s3)
    print(res)
    assert(res)
  }

}
