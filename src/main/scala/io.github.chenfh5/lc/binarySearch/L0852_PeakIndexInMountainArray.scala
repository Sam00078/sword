package io.github.chenfh5.lc.binarySearch

object L0852_PeakIndexInMountainArray {

  // @see https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C++JavaPython-Better-than-Binary-Search
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    var (lo, hi) = (0, A.length - 1)
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2
      if (A(mid) < A(mid + 1)) lo = mid + 1 // since lo < hi, so mid < len, mid+1 may be len, but question is mountain
      else hi = mid
    }
    lo
  }

  def main(args: Array[String]) {
    val A = Array(0, 2, 1, 0)
    val res = peakIndexInMountainArray(A)
    print(res)
  }

}
