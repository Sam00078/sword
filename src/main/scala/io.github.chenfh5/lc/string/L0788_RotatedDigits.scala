package io.github.chenfh5.lc.string

object L0788_RotatedDigits {

  // @see https://leetcode.com/problems/rotated-digits/discuss/116547/Easily-Understood-Java-Solution
  def rotatedDigits(N: Int): Int = {
    var cnt = 0
    for (i <- 1 to N) {
      if (isValid(i)) cnt += 1
    }
    cnt
  }

  def isValid(_N: Int): Boolean = {
    // valud if N contains at least one `1,5,6,9` and no contains `3,4 or 7`
    var N = _N
    var validFound = false
    while (N > 0) {
      val d = N % 10 // digital
      if (d == 2 || d == 5 || d == 6 || d == 9) validFound = true
      if (d == 3 || d == 4 || d == 7) return false
      N = N / 10
    }
    validFound
  }

  def main(args: Array[String]) {
    val input = 10
    val res = rotatedDigits(input)
    print(res)
    assert(res == 4)
  }

}
