package io.github.chenfh5.lc.string

object L0434_CountSegments {

  def countSegments(s: String): Int = {
    var res = 0
    for (i <- 0 until s.length) {
      if (s(i) != ' ' && (i == 0 || s(i - 1) == ' ')) res += 1
    }
    res
  }

  // @see https://leetcode.com/submissions/detail/170598137/
  def countSegments2(s: String): Int = {
    if (s.length == 0) 0 else s split "\\s+" count (_.length > 0)
  }

  def main(args: Array[String]) {
    val s = "Hello, my name is John"
    val res = countSegments(s)
    print(res)
    assert(res == 5)
  }

}
