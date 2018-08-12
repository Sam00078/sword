package io.github.chenfh5.lc.array

object L0755_IdealPermutation {

  // @see https://leetcode.com/problems/global-and-local-inversions/discuss/113644/Easy-and-Concise-Solution-C++JavaPython
  def isIdealPermutation(A: Array[Int]): Boolean = {
    var max = 0
    for (i <- 0 until A.length - 2) {
      max = math.max(max, A(i)) // we can not find A[i] > A[j] with i+2<=j. i.e, max(A[i]) < A[i+2] always true
      if (max > A(i + 2)) return false // local inversions A[i] > A[i+1]
    }
    true
  }

  def isIdealPermutation2(A: Array[Int]): Boolean = {
    for (i <- 0 until A.length) {
      if (math.abs(A(i) - i) >= 2) return false // A of [0, 1, ..., N - 1]
    }
    true
  }

  def main(args: Array[String]) {
    val A = Array(1, 0, 2)
    val res = isIdealPermutation(A)
    print(res)
    assert(res)
  }

}
