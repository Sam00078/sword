package io.github.chenfh5.lc.binarySearch

object L0668_findKthNumberInMultiplicationTable {

  // @see https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/discuss/106977/Java-solution-binary-search
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    var (lo, hi) = (0, m * n)
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2 // mid value of the whole matrix at first
      val cnt = count(mid, m, n)
      if (cnt < k) lo = mid + 1 // not enough
      else hi = mid
    }
    lo
  }

  def count(mid: Int, m: Int, n: Int): Int = {
    var cnt = 0
    for (i <- 1 to m) {
      // row from 1 to end
      // the largest num in row i, is k*i->last -> k= last/i -> cnt=mid/i
      val temp = math.min(mid / i, n) // In the i-th row, the table looks like [i, 2*i, 3*i, ..., n*i]. @see leetcode.com/problems/kth-smallest-number-in-multiplication-table/discuss/106984/Python-Straightforward-with-Explanation/109269
      cnt += temp
    }
    cnt
  }

  def main(args: Array[String]) {

  }

}
