package io.github.chenfh5.leetcode.twoPointers

object L0844_BackspaceCompare {

  def backspaceCompare(S: String, T: String): Boolean = {
    getStr(S) == getStr(T)
  }

  @inline
  def getStr(str: String): String = {
    var res = ""
    for (i <- 0 until str.length) {
      val char = str(i)
      if (char == '#') res = res.dropRight(1)
      else res += char
    }
    res
  }

  def main(args: Array[String]) {
    val S = "ab#c"
    val T = "ad#c"
    val res = backspaceCompare(S, T)
    print(res)
    assert(res)
  }

}
