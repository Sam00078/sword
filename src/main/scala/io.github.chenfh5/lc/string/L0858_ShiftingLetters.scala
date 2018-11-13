package io.github.chenfh5.lc.string

object L0858_ShiftingLetters {

  // @see https://leetcode.com/problems/shifting-letters/discuss/137906/C++JavaPython-Easy-Understood
  def shiftingLetters(S: String, shifts: Array[Int]): String = {
    val res = new StringBuilder(S)
    for (i <- Range(shifts.length - 2, 0, -1).inclusive)
      shifts(i) = (shifts(i) + shifts(i + 1)) % 26 // from right to left to count the accumulate sum of shift action count
    for (i <- 0 until S.length)
      res.setCharAt(i, ((S(i) - 'a' + shifts(i)) % 26 + 'a').toChar) // do shifting
    res.toString()
  }

  def main(args: Array[String]) {
    val S = "abc"
    val shifts = Array(3, 5, 9)
    val res = shiftingLetters(S, shifts)
    print(res)
    assert(res == "rpl")
  }

}
