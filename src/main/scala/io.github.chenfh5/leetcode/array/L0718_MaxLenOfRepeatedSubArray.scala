package io.github.chenfh5.leetcode.array

object L0718_MaxLenOfRepeatedSubArray {

  // @see https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/Concise-Java-DP:-Same-idea-of-Longest-Common-Substring/123015
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    //dp(i)(j) is the length of `longest common subarray` ending with nums[i] and nums[j], accumulated
    val dp = Array.ofDim[Int](A.length + 1, B.length + 1)
    var maxLen = 0

    for (i <- 0 until A.length) {
      for (j <- 0 until B.length) {
        if (A(i) == B(j)) {
          dp(i + 1)(j + 1) = dp(i)(j) + 1
          maxLen = math.max(maxLen, dp(i + 1)(j + 1))
        }
      }
    }
    maxLen
  }

  def main(args: Array[String]) {
    val A = Array(1, 2, 3, 2, 1)
    val B = Array(3, 2, 1, 4, 7)
    val res = findLength(A, B)
    print(res)
    assert(res == 3)
  }

}
