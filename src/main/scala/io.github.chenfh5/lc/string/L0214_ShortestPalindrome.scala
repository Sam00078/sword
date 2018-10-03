package io.github.chenfh5.lc.string

object L0214_ShortestPalindrome {

  // @see https://leetcode.com/problems/shortest-palindrome/discuss/60106/My-9-lines-three-pointers-Java-solution-with-explanation
  def shortestPalindrome(s: String): String = {
    val len = s.length
    var (i, j, curTail) = (0, len - 1, len - 1)
    // find the longest palindrome starting from the first character
    while (i < j) {
      if (s(i) == s(j)) {
        i += 1
        j -= 1
      } else {
        i = 0 // reset to first head
        curTail -= 1 // current tail eq previous tail minus one
        j = curTail // reset to the current tail
      }
    }
    s.substring(curTail + 1).reverse + s
  }

  def main(args: Array[String]) {
    val s = "aacecqaaa"
    val res = shortestPalindrome(s)
    print(res)
    assert(res == "aaacecaaa")
  }

}
