package io.github.chenfh5.leetcode.twoPointers

object L0845_LongestMountain {

  // @see https://leetcode.com/problems/longest-mountain-in-array/discuss/150136/Simple-O(n)-one-pass-O(1)-space-Java-AC-solution-beats-99.05
  def longestMountain(A: Array[Int]): Int = {
    var max = 0
    // a one-pass algorithm is a streaming algorithm which reads its input exactly once
    for (i <- 1 until A.length - 1) {
      // find the local mountain
      if (A(i - 1) < A(i) && A(i) > A(i + 1)) {
        var (l, r) = (i - 1, i + 1)
        while (l > 0 && A(l - 1) < A(l)) l -= 1 //find the left bound
        while (r < A.length - 1 && A(r) > A(r + 1)) r += 1 // find the right bound
        max = math.max(max, r - l + 1) // find the global mountain
      }
    }
    max
  }

  def main(args: Array[String]) {
    val A = Array(2, 1, 4, 7, 3, 2, 5)
    val res = longestMountain(A)
    print(res)
    assert(res == 5)
  }

}
