package io.github.chenfh5.leetcode.string

object L0856_ScoreofParentheses {

  // @see https://leetcode.com/problems/score-of-parentheses/discuss/141777/C++JavaPython-Concise-O(1)-Space
  def scoreOfParentheses(S: String): Int = {
    var res, layers = 0
    for (i <- 0 until S.length) {
      if (S(i) == '(') layers += 1 else layers -= 1
      if (i < S.length() - 1 && S(i) == '(' && S(i + 1) == ')') res += (1 << layers - 1) // 2^(layers-1)
    }
    res
  }

  def main(args: Array[String]) {
    val input = "(()(()))"
    val res = scoreOfParentheses(input)
    println(res)
    assert(res == 6)
  }

}
