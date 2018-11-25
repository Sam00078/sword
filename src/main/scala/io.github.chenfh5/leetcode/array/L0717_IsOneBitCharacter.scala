package io.github.chenfh5.leetcode.array

object L0717_IsOneBitCharacter {

  // @see https://leetcode.com/problems/1-bit-and-2-bit-characters/discuss/108969/Java-solution-1-or-2/147912
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    var (i, len) = (0, bits.length)
    while (i < len) {
      if (i == len - 1 && bits(i) == 0) return true // need one-bit character
      if (bits(i) == 1) i += 2 // skip this two-bit character
      else i += 1 // one-bit character only
    }
    false
  }

  def main(args: Array[String]) {
    val bits = Array(1, 0, 0)
    val res = isOneBitCharacter(bits)
    print(res)
    assert(res)
  }

}
