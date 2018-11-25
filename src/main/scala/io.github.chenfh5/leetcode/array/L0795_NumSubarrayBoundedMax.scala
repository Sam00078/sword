package io.github.chenfh5.leetcode.array

object L0795_NumSubarrayBoundedMax {

  // @see https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/117616/C++-O(n)-less10-lines
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
    var (left, right, res) = (-1, -1, 0)
    for (i <- 0 until A.length) {
      // the max of subArray between [L,R]
      if (A(i) > R) left = i // left is track by >R
      if (A(i) >= L) right = i // right is track by >=L
      res += right - left // every loop if A(i) smaller, but right > left, then append to the subArray
    }
    res
  }

  def main(args: Array[String]) {
    val A = Array(2, 1, 4, 3)
    val res = numSubarrayBoundedMax(A, 2, 3)
    print(res)
    assert(res == 3)
  }

}
