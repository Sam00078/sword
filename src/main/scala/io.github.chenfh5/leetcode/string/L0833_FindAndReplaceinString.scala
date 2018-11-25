package io.github.chenfh5.leetcode.string


object L0833_FindAndReplaceinString {

  // @see https://leetcode.com/problems/find-and-replace-in-string/discuss/130587/C++JavaPython-Replace-S-from-right-to-left
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    var s = S
    import scala.collection.mutable.ListBuffer
    var sorted = ListBuffer[Array[Int]]()
    for (i <- 0 until indexes.length) sorted.append(Array(indexes(i), i))
    sorted = sorted.sortBy(e => -e.head) // from right to left to get rid of the appending or deleting words to affect the after but no the before

    for (one <- sorted) {
      val (index, inner) = (one.head, one.last)
      val (src, tar) = (sources(inner), targets(inner))
      if (s.substring(index, index + src.length) == src) {
        s = s.substring(0, index) + tar + s.substring(index + src.length)
      }
    }
    s
  }

  def main(args: Array[String]) {
    val S = "abcd"
    val indexes = Array(0, 2)
    val sources = Array("ab", "ec")
    val targets = Array("eee", "ffff")
    val res = findReplaceString(S, indexes, sources, targets)
    print(res)
  }

}
