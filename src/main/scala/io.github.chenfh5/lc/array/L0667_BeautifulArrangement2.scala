package io.github.chenfh5.lc.array

object L0667_BeautifulArrangement2 {

  /*
    @see [[https://leetcode.com/problems/beautiful-arrangement-ii/discuss/106963/Java-simple-solution]]
    @see [[https://leetcode.com/problems/beautiful-arrangement-ii/discuss/106948/C++-Java-Clean-Code-4-liner]]
    if you have n number, the maximum k can be n - 1

      i: 1   2   3   4   5
      j:   9   8   7   6
    out: 1 9 2 8 3 7 4 6 5
    dif:  8 7 6 5 4 3 2 1
     */
  def constructArray(n: Int, k: Int): Array[Int] = {
    val res = new Array[Int](n)
    var (low, high) = (1, k + 1) // 1<=k<=n-1
    for (i <- 0 until k + 1) {
      // 0~k+1 has k part, means k diffs
      if (i % 2 == 0) {
        res(i) = low
        low += 1
      } else {
        res(i) = high
        high -= 1
      }
    }
    // set the remain
    for (i <- k + 1 until n) {
      res(i) = i + 1
    }
    res
  }

  def main(args: Array[String]) {
    val res = constructArray(3, 2)
    print(res.toList)
    val assertNums = Array(1, 3, 2)
    for (i <- res.indices) {
      assert(res(i) == assertNums(i))
    }
  }

}
