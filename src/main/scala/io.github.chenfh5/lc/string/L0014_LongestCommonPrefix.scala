package io.github.chenfh5.lc.string

object L0014_LongestCommonPrefix {

  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs == null || strs.length < 1) return ""

    var (minLen, res) = (Int.MaxValue, "")
    for (str <- strs) minLen = math.min(minLen, str.length)
    for (i <- 0 until minLen) {
      val curChar = strs.head(i)
      for (j <- 1 until strs.length) {
        if (curChar != strs(j)(i)) return res
      }
      res += curChar
    }
    res
  }

  def main(args: Array[String]) {
    val strs = Array("flower", "flow", "flight")
    val res = longestCommonPrefix(strs)
    print(res)
    assert(res == "fl")
  }

}
