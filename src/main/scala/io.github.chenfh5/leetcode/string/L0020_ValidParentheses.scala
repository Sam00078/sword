package io.github.chenfh5.leetcode.string


object L0020_ValidParentheses {

  // @see https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
  def isValid(s: String): Boolean = {
    import scala.collection.mutable
    if (s.length % 2 != 0) return false
    val stack = new mutable.Stack[Char]()
    for (c <- s) {
      if (c == '(') stack.push(')')
      else if (c == '[') stack.push(']')
      else if (c == '{') stack.push('}')
      else if (stack.isEmpty || stack.pop() != c) return false // only buckets char
    }
    stack.isEmpty
  }

  def main(args: Array[String]) {
    val input = "{[()]}"
    val res = isValid(input)
    assert(res)
  }

}
