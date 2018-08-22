package io.github.chenfh5.lc.string

object L0557_ReverseWords3 {

  // @see https://leetcode.com/problems/reverse-words-in-a-string-iii/discuss/101963/Easiest-Java-Solution-(9ms)-Similar-to-Reverse-Words-in-a-String-II/105553
  def reverseWords(s: String): String = {
    val (arr, len) = (s.toCharArray, s.length)
    var left = 0
    for (right <- 0 to len) {
      if (right == len || arr(right) == ' ') {
        swap(arr, left, right - 1) // may also swap consecutive whitespace
        left = right + 1 // skip current whitespace
      }
    }
    arr.mkString
  }

  def swap(s: Array[Char], left: Int, right: Int) = {
    var (i, j) = (left, right)
    while (i < j) {
      val temp = s(i)
      s(i) = s(j)
      s(j) = temp
      i += 1
      j -= 1
    }
  }

  // @see https://leetcode.com/submissions/detail/171018331/
  def reverseWords2(s: String): String = s.split(" ").map(_.reverse).mkString(" ")

  def main(args: Array[String]) {
    val s = "Let's take LeetCode contest"
    val res = reverseWords(s)
    print(res)
    assert(res == "s'teL ekat edoCteeL tsetnoc")
  }

}
