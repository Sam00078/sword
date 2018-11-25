package io.github.chenfh5.leetcode.array

object L0870_AdvantageCount {

  // @see https://leetcode.com/problems/advantage-shuffle/discuss/149840/C++Java-Greedy-Solution-Using-Map
  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    var mapA = scala.collection.immutable.TreeMap[Int, Int]()
    for (one <- A) mapA += (one -> (mapA.getOrElse(one, 0) + 1))

    val res = new Array[Int](A.length)
    // use the least(A) greater than the specified(B), so A[i] > B[i] is true, without waste
    for (i <- 0 until B.length) {
      val leastAGtB = mapA.from(B(i) + 1) // Gets the entry for the least key greater than the specified key
      val keyA = if (leastAGtB.size < 1) mapA.firstKey else leastAGtB.firstKey
      mapA += (keyA -> (mapA.get(keyA).head - 1)) // this key in A have been used, so minus 1, till zero
      if (mapA.get(keyA).head == 0) mapA -= keyA
      res(i) = keyA
    }
    res
  }

  def main(args: Array[String]) {
    val (a, b) = (Array(12, 24, 8, 32), Array(13, 25, 32, 11))
    val res = advantageCount(a, b)
    print(res.toList)
    val expect = Array(24, 32, 8, 12)
    assert(res sameElements expect)
  }

}
