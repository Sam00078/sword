package io.github.chenfh5.leetcode.binarySearch

object L0050_MyPow {

  // @see https://leetcode.com/problems/powx-n/discuss/19544/5-different-choices-when-talk-with-interviewers/19664
  def myPow(x: Double, n: Int): Double = {
    if (n >= 0) helper(x, n)
    else 1 / helper(x, -n)
  }

  def helper(x: Double, n: Int): Double = {
    if (n == 0) return 1
    var res = helper(x, n / 2) // each time n cut half
    res *= res
    if (n % 2 != 0) res *= x // if n is odd, since /2 get rid of the float(3/2==2/2), need compensate one x
    res
  }

  def main(args: Array[String]) {
    val res = myPow(2.0, -2)
    print(res)
    assert(res == 0.25)
  }

}
