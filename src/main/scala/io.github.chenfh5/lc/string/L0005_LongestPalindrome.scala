package io.github.chenfh5.lc.string

object L0005_LongestPalindrome {

  // @see https://leetcode.com/problems/longest-palindromic-substring/discuss/3060/(AC)-relatively-short-and-very-clear-Java-solution
  def longestPalindrome(s: String): String = {
    var (res, curLen) = ("", 0)

    for (i <- 0 until s.length) {
      // now i and its head is match palindrome? (its head's len should ge curlen)
      // gt curLen should be considered
      if (isPalindrome(s, i - curLen - 1, i)) {
        // size=curlen+2, gt 2 is also palindrome have already considered
        res = s.substring(i - curLen - 1, i + 1) // exclusive end
        curLen = curLen + 2
        // eq curLen should be considered
      } else if (isPalindrome(s, i - curLen, i)) {
        // size=curlen+1, less than should be ignore
        res = s.substring(i - curLen, i + 1)
        curLen = curLen + 1
      }
    }
    res
  }

  def isPalindrome(s: String, begin: Int, end: Int): Boolean = {
    if (begin < 0) return false
    var (i, j) = (begin, end)
    while (i < j) {
      if (s(i) != s(j)) return false
      i += 1
      j -= 1
    }
    true
  }

  def main(args: Array[String]) {
    val s = "xb9xaybayo" // bab or aba
    val res = longestPalindrome(s)
    print(res)
    assert(res == "x")
  }

}
