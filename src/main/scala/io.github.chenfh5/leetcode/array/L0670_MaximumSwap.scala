package io.github.chenfh5.leetcode.array

object L0670_MaximumSwap {

  // @see https://leetcode.com/problems/maximum-swap/discuss/107102/Simple-AC-O(n)-java-solution-with-ex
  def maximumSwap(num: Int): Int = {
    val digits = num.toString.toCharArray // many digital = digits
    var first_greater_pos = 1
    // 0. find first greater digit than the previous to split two part
    while (first_greater_pos < digits.length &&
        digits(first_greater_pos - 1) >= digits(first_greater_pos)) {
      first_greater_pos += 1
    }
    if (first_greater_pos == digits.length) return num //all digits are desc sorted already, no need to swap

    // 1. find max digit in remain digits in right-part
    var (max, max_pos) = ('0', first_greater_pos)
    for (i <- Range(digits.length - 1, first_greater_pos, -1).inclusive) {
      if (digits(i) > max) {
        max = digits(i)
        max_pos = i
      }
    }

    // 2. find first digit that smaller than max digit in left-part
    for (i <- 0 until first_greater_pos) {
      if (digits(i) < max) {
        val temp = digits(i)
        digits(i) = max
        digits(max_pos) = temp
        return digits.mkString.toInt
      }
    }
    digits.mkString.toInt
  }

  def main(args: Array[String]) {
    val res = maximumSwap(11993)
    print(res)
    assert(res == 91913)
  }

}
