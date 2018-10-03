package io.github.chenfh5.lc.binarySearch

object L0658_FindClosestElements {

  // @see https://leetcode.com/problems/find-k-closest-elements/discuss/106419/O(log-n)-Java-1-line-O(log(n)-+-k)-Ruby
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
    // find first index
    var (i, j) = (0, arr.length - k)
    while (i < j) {
      val mid = i + (j - i) / 2
      if (math.abs(arr(mid) - x) > math.abs(arr(mid + k) - x)) i = mid + 1 // the left part is too large
      else j = mid
    }
    arr.slice(i, i + k).toList
  }

  def main(args: Array[String]) {
    val arr = Array(1, 2, 3, 4, 5)
    val res = findClosestElements(arr, 4, 3)
    print(res)
    assert(res == List(1, 2, 3, 4))
  }

}
