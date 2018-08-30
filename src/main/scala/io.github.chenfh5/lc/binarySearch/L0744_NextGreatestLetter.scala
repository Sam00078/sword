package io.github.chenfh5.lc.binarySearch

object L0744_NextGreatestLetter {

  // @see https://leetcode.com/problems/find-smallest-letter-greater-than-target/discuss/110005/Easy-Binary-Search-in-Java-O(log(n))-time
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    var (lo, hi) = (0, letters.length)
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2
      if (letters(mid) <= target) lo = mid + 1 // equal should be not right, since it need next
      else hi = mid
    }
    letters(lo % letters.length) // wrap around. only(lo=len)
  }

  def main(args: Array[String]) {
    val letters = Array[Char]('c', 'f', 'j')
    val res = nextGreatestLetter(letters, 'c')
    print(res)
    assert(res == 'c')
  }

}
