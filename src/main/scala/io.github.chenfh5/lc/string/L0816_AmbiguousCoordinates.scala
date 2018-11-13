package io.github.chenfh5.lc.string

import scala.collection.mutable.ListBuffer

object L0816_AmbiguousCoordinates {


  // @see https://leetcode.com/problems/ambiguous-coordinates/discuss/123851/C++JavaPython-Solution-with-Explanation
  def ambiguousCoordinates(S: String): List[String] = {
    val n = S.length
    val res = ListBuffer[String]()
    for (i <- 1 until n - 2) {
      val A = f(S.substring(1, i + 1))
      val B = f(S.substring(i + 1, n - 1))
      for (a <- A) for (b <- B) res.append('(' + a + ", " + b + ')')
    }
    res.toList
  }

  def f(s: String): ListBuffer[String] = {
    val n = s.length
    val res = ListBuffer[String]()
    if (n == 0 || (n > 1 && s.head == '0' && s.last == '0')) return res
    if (n > 1 && s.head == '0') {
      res.append("0." + s.substring(1)) // 0.xxx
      return res
    }
    res.append(s)
    if (n == 1 || s(n - 1) == '0') return res // only one letter in s
    for (i <- 1 until n) {
      res.append(s.substring(0, i) + '.' + s.substring(i)) // x.xxx, xx.xx, xxx.x
    }
    res
  }

  def main(args: Array[String]) {
    val input = "(0123)"
    val res = ambiguousCoordinates(input)
    print(res)
  }

}
