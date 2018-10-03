package io.github.chenfh5.lc.string

object L0032_LongestValidParentheses {

  // @see https://leetcode.com/problems/longest-valid-parentheses/discuss/14167/Simple-JAVA-solution-O(n)-time-one-stack
  def longestValidParentheses(s: String): Int = {
    val stack = scala.collection.mutable.Stack[Int]()
    var (left, max) = (-1, 0) // left is a pair, at least eq 2
    for (right <- 0 until s.length) {
      if (s(right) == '(') stack.push(right)
      else {
        if (stack.isEmpty) left = right // now is ')'. e.g., )))), left would be right
        else {
          stack.pop() // pop the newly '(' -> a pair need remove sync
          if (stack.isEmpty) max = math.max(max, right - left) // e.g. ))))() -> )))) -> 5-3
          else max = math.max(max, right - stack.top) // e.g. ))))()() -> minus the closest `(` pos
        }
      }
    }
    max
  }

  def main(args: Array[String]) {
    val s = ")()())"
    val res = longestValidParentheses(s)
    print(res)
    assert(res == 4)
  }

}
