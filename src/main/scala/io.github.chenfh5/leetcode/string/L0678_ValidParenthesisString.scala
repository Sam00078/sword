package io.github.chenfh5.leetcode.string


object L0678_ValidParenthesisString {

  // @see https://leetcode.com/problems/valid-parenthesis-string/discuss/139759/Java-Very-easy-solution.-No-recursion-or-dp.
  def checkValidString(s: String): Boolean = {
    // The first loop check sto see if we have enough '(' and '*' characters to balance out the ')' character. If balance >= 0. Then we have more than enough.
    var balance = 0
    for (oneChar <- s) {
      if (oneChar == '(' || oneChar == '*') balance += 1
      else balance -= 1
      if (balance < 0) return false
    }
    if (balance == 0) return true // no need to loop second
    // The second loop checks to see if we have enough ')' and '*' to balance out the '(' character
    balance = 0
    for (i <- Range(s.length - 1, 0, -1).inclusive) {
      if (s(i) == ')' || s(i) == '*') balance += 1
      else balance -= 1
      if (balance < 0) return false
    }
    true
  }

  def main(args: Array[String]) {
    val input = "(())((())()()(*)(*()(())())())()()((()())((()))(*"
    val res = checkValidString(input)
    print(res)
    assert(!res)
  }

}
