package io.github.chenfh5.leetcode.string

object L0899_OrderlyQueue {

  // @see https://leetcode.com/problems/orderly-queue/discuss/165878/C++JavaPython-Sort-String-or-Rotate-String
  def orderlyQueue(S: String, K: Int): String = {
    if (K > 1) return S.sortWith(_ < _)
    var res = S
    for (i <- 1 until S.length) {
      val temp = S.substring(i) + S.substring(0, i) // rotate
      if (res > temp) res = temp // drop bigger
    }
    res
  }

  def main(args: Array[String]) {
    val S = "baaca"
    val K = 3
    val res = orderlyQueue(S, K)
    println(res)
    assert(res == "aaabc")
  }

}
