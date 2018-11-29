package io.github.chenfh5.leetcode.array

object L0873_LenOfLongestFibSubseq {

  // @see https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/152343/C++JavaPython-Check-Pair
  def lenLongestFibSubseq(A: Array[Int]): Int = {
    val set = A.toSet // convert whole already
    var res = 2
    for (i <- 0 until A.length) {
      // double loop to avoid only head element to be consider
      for (j <- i + 1 until A.length) {
        var (f1, f2, curLen) = (A(i), A(j), 2)
        while (set.contains(f1 + f2)) {
          // use hashSet to determined quickly whether exists f3 in the latter
          f2 = f2 + f1 // next step
          f1 = f2 - f1 // i.e., raw f2
          curLen += 1
        }
        res = math.max(res, curLen)
      }
    }
    if (res > 2) res else 0
  }

  def main(args: Array[String]) {
    val A = Array(1, 3, 7, 11, 12, 14, 18)
    val res = lenLongestFibSubseq(A)
    print(res)
    assert(res == 3)
  }

}
