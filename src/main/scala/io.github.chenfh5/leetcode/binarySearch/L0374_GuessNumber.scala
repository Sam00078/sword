package io.github.chenfh5.leetcode.binarySearch

object L0374_GuessNumber {

  // @see https://leetcode.com/problems/guess-number-higher-or-lower/discuss/84668/Short-Java-code-using-binary-search
  // TODO
  def guessNumber(n: Int): Int = {
    var (i, j) = (0, n)
    while (i < j) {
      val mid = i + (j - i) / 2
      if (guess(mid) == 0) return mid
      else if (guess(mid) == 1) i = mid + 1
      else j = mid
    }
    i
  }

  def guess(n: Int): Int = {
    1
  }

  def main(args: Array[String]) {

  }

}
