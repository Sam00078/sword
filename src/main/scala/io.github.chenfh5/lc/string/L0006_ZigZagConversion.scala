package io.github.chenfh5.lc.string

object L0006_ZigZagConversion {

  // make the `Z` back to one str, i.e., recovery
  // @see https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
  def convert(s: String, numRows: Int): String = {
    val len = s.length
    val sb = Array.ofDim[StringBuilder](numRows)
    for (idx <- 0 until sb.length) sb(idx) = new StringBuilder() // initial

    var i = 0
    while (i < len) {
      // vertically down
      for (idx <- 0 until numRows if i < len) {
        sb(idx).append(s(i))
        i += 1
      }
      // obliquely up
      for (idx <- Range(numRows - 2, 1, -1).inclusive if i < len) {
        sb(idx).append(s(i))
        i += 1
      }
    }
    for (idx <- 1 until sb.length) sb(0).append(sb(idx))
    sb(0).toString()
  }

  def main(args: Array[String]) {
    val s = "PAYPALISHIRING"
    val res = convert(s, 4)
    print(res)
    assert(res == "PINALSIGYAHRPI")
  }

}
