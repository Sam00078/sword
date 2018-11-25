package io.github.chenfh5.leetcode.string

object L0541_ReverseStr {

  /**
    * 0            k           2k          3k
    * |-----------|-----------|-----------|---
    * +--reverse--+           +--reverse--+
    */
  // @see http://leetcode.com/problems/reverse-string-ii/discuss/100887/C++Java-Clean-Code/104799
  def reverseStr(s: String, k: Int): String = {
    var (reverseLeftPos, arr, len) = (0, s.toCharArray, s.length)
    while (reverseLeftPos < len) {
      var reverseRightPos = math.min(reverseLeftPos + k - 1, len - 1) // to the end or not(01`23`45)->k=2,->0,4
      val nextLeft = reverseRightPos + k + 1 // 1+k(2)+1=4. Next pos of the reverse tail
      while (reverseLeftPos < reverseRightPos) {
        // in the reverse range
        swap(arr, reverseLeftPos, reverseRightPos)
        reverseLeftPos += 1
        reverseRightPos -= 1
      }
      reverseLeftPos = nextLeft
    }
    arr.mkString
  }

  def swap(arr: Array[Char], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def main(args: Array[String]) {
    val s = "abcdefg"
    val res = reverseStr(s, 2)
    print(res)
  }

}
