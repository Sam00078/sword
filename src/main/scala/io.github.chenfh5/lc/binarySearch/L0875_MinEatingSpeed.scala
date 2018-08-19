package io.github.chenfh5.lc.binarySearch

object L0875_MinEatingSpeed {

  // @see https://leetcode.com/problems/koko-eating-bananas/discuss/152324/C++JavaPython-Binary-Search
  def minEatingSpeed(piles: Array[Int], H: Int): Int = {
    var (lo, hi) = (0, 10e9.toInt) // eat speed range
    while (lo < hi) {
      var (mid, totalEatTimeInSpeedMid) = (lo + (hi - lo) / 2, 0) // real try speed
      for (p <- piles) totalEatTimeInSpeedMid += math.ceil(p.toDouble / mid).toInt // not floor
      if (totalEatTimeInSpeedMid > H) lo = mid + 1
      else hi = mid
    }
    lo
  }

  def main(args: Array[String]) {
    val piles = Array(30, 11, 23, 4, 20)
    val res = minEatingSpeed(piles, 6)
    print(res)
    assert(res == 23)
  }

}
