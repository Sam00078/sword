package io.github.chenfh5.leetcode.string

object L0010_RegularExpressionMatching {

  // @see https://www.cnblogs.com/grandyang/p/4461713.html, method 3
  // @see https://leetcode.com/problems/regular-expression-matching/discuss/5684/9-lines-16ms-c-dp-solutions-with-explanations
  def isMatch(s: String, p: String): Boolean = {
    val dp = Array.ofDim[Boolean](s.length + 1, p.length + 1) // dp[i][j]表示s[0,i)和p[0,j)是否match
    dp(0)(0) = true

    for (i <- 0 to s.length) {
      for (j <- 1 to p.length) {
        if (p(j - 1) == '*')
        // *表示之前那个字符可以有0个，1个或是多个
        // 123qqqqqq
        // 123q*
          dp(i)(j) = (i > 0 && (s(i - 1) == p(j - 2) || p(j - 2) == '.') && dp(i - 1)(j)) || dp(i)(j - 2) // repeat ge 1 times || repeat 0 time
        else
          dp(i)(j) = i > 0 && (s(i - 1) == p(j - 1) || p(j - 1) == '.') && dp(i - 1)(j - 1)
      }
    }
    dp.last.last
  }

  def main(args: Array[String]) {
    val res = isMatch("mississippi", "mis*is*p*.")
    print(res)
    assert(!res)
  }

}
