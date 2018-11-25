package io.github.chenfh5.leetcode.string

object L0686_RepeatedStringMatch {

  def repeatedStringMatch(A: String, B: String): Int = {
    val sb = new StringBuilder()
    var cnt = 0
    while (sb.length < B.length) {
      sb.append(A)
      cnt += 1
    }
    if (sb.toString().contains(B)) return cnt // extra substring
    if (sb.append(A).toString().contains(B)) return cnt + 1 // need one more
    -1
  }

  def main(args: Array[String]) {
    val (a, b) = ("abcd", "cdabcdab")
    val res = repeatedStringMatch(a, b)
    print(res)
    assert(res == 3)
  }

}
