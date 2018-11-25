package io.github.chenfh5.leetcode.string

object L0791_CustomSortString {

  // @see https://leetcode.com/problems/custom-sort-string/discuss/116573/Java-Bucket-sort-solution-O(N+M)-with-follow-up-questions
  def customSortString(S: String, T: String): String = {
    // initial T
    val bucket = new Array[Int](26)
    for (t <- T) {
      bucket(t - 'a') += 1
    }
    // loop S
    val sb = new StringBuilder()
    for (s <- S) {
      for (i <- 0 until bucket(s - 'a')) {
        sb.append(s)
      }
      bucket(s - 'a') = 0
    }
    // append the remain
    for (i <- 0 until 26) {
      for (j <- 0 until bucket(i)) {
        sb.append((i + 'a').toChar) // repeat bucket(i) times
      }
    }
    sb.toString()
  }

  def main(args: Array[String]) {
    val S = "cba"
    val T = "abcd"
    val res = customSortString(S, T)
    print(res)
    assert(res == "cbad")
  }

}
