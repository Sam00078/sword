package io.github.chenfh5.lc.string

object L0521_FindLUSlength {

  def findLUSlength(a: String, b: String): Int = {
    if (a == b) -1 else math.max(a.length, b.length) // need to find uncommon
  }

  def main(args: Array[String]) {
    val res = findLUSlength("cc", "ccc")
    print(res)
    assert(res == 3)
  }

}
