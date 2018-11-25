package io.github.chenfh5.leetcode.string

object L0937_ReorderLogFiles {

  // TODO
  // @see https://leetcode.com/problems/reorder-log-files/discuss/192350/Java-8-using-lambda-function
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    if (logs == null || logs.length == 0) return logs
    implicit val KeyOrdering = new Ordering[String] {
      override def compare(a: String, b: String): Int = {
        val a1 = a.substring(a.indexOf(" ") + 1)
        val b1 = b.substring(b.indexOf(" ") + 1)
        val (af, bf) = (a1.head, b1.head)

        if (af.isLetter && bf.isDigit) return -1
        if (af.isDigit && bf.isLetter) return 1
        if (af.isDigit && bf.isDigit) return 0
        a.compareTo(b)
      }
    }
    logs.sorted(KeyOrdering)
  }

  def main(args: Array[String]) {
    val input = Array("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo")
    val res = reorderLogFiles(input)
    val expect = Array("g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7")
    println(res.toList)
  }

}
