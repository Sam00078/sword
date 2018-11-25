package io.github.chenfh5.leetcode.string


object L0893_GroupsofSpecialEquivalentStrings {

  // @see https://leetcode.com/problems/groups-of-special-equivalent-strings/discuss/163413/Java-Concise-Set-Solution
  def numSpecialEquivGroups(A: Array[String]): Int = {
    import scala.collection.mutable
    val set = mutable.HashSet[String]()
    for (s <- A) {
      val odd = new Array[Int](26) // ji
      val even = new Array[Int](26) // ou
      for (i <- 0 until s.length) {
        if (i % 2 == 1) odd(s(i) - 'a') += 1 // (letter -> letterCnt)
        else even(s(i) - 'a') += 1
      }
      val sign = odd.mkString("") + even.mkString("") // len=26*2
      set.add(sign)
    }
    set.size
  }

  def main(args: Array[String]) {
    val input = Array("abc", "acb", "bac", "bca", "cab", "cba")
    val res = numSpecialEquivGroups(input)
    println(res)
    assert(res == 3)
  }

}
