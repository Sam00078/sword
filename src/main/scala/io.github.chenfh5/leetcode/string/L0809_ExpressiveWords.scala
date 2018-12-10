package io.github.chenfh5.leetcode.string

object L0809_ExpressiveWords {

  // @see https://leetcode.com/problems/expressive-words/discuss/122660/C++JavaPython-2-Pointers-and-4-pointers
  def expressiveWords(S: String, words: Array[String]): Int = {
    var res = 0
    for (word <- words) {
      if (check(S, word)) {
        res += 1
      }
    }
    res
  }

  def check(S: String, word: String): Boolean = {
    val (n, m) = (S.length, word.length)
    var j = 0
    for (i <- 0 until n) {
      if (j < m && S(i) == word(j)) j += 1
      else if (i > 1 && S(i) == S(i - 1) && S(i - 1) == S(i - 2)) None // skip
      else if (i > 0 && i < n - 1 && S(i) == S(i - 1) && S(i) == S(i + 1)) None //skip
      else return false
    }
    j == m
  }

  def main(args: Array[String]) {
    val S = "heeellooo"
    val words = Array("hello", "hi", "helo")
    val res = expressiveWords(S, words)
    print(res)
    assert(res == 1)
  }

}
