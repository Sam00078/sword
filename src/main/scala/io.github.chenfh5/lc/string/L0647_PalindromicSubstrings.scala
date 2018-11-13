package io.github.chenfh5.lc.string

object L0647_PalindromicSubstrings {

  // @see https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome/144768
  def countSubstrings(s: String): Int = {
    var cnt = 0
    for (i <- 0 until s.length) {
      cnt += extendPalindrome(s, i, i) // self-count. To check the palindrome of `odd` length palindromic sub-string
      cnt += extendPalindrome(s, i, i + 1) // self-next-count. `even` length(0,2,4,6..)
    }
    cnt
  }

  def extendPalindrome(str: String, left: Int, right: Int): Int = {
    var (localCnt, i, j) = (0, left, right)
    while (i >= 0 && j < str.length && str(i) == str(j)) {
      localCnt += 1
      i -= 1
      j += 1
    }
    localCnt
  }

  def main(args: Array[String]) {
    val input = "aaa"
    val res = countSubstrings(input)
    print(res)
    assert(res == 6)
  }

}
