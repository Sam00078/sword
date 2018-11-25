package io.github.chenfh5.leetcode.string

object L0680_ValidPalindrome2 {

  // @see https://leetcode.com/problems/valid-palindrome-ii/discuss/107717/C++Java-Clean-Code-2-liner-Generic-for-"you-may-delete-at-most-N-character"
  def validPalindrome(s: String): Boolean = {
    var (left, right) = (0, s.length - 1)
    while (left < right) {
      if (s(left) != s(right)) {
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1) // at most one delete
      }
      left += 1
      right -= 1
    }
    true
  }

  def isPalindrome(str: String, _left: Int, _right: Int): Boolean = {
    var (left, right) = (_left, _right)
    while (left < right) {
      if (str(left) != str(right)) return false
      left += 1
      right -= 1
    }
    true
  }

  def main(args: Array[String]) {
    val input = "abca"
    val res = validPalindrome(input)
    print(res)
    assert(res)
  }

}
