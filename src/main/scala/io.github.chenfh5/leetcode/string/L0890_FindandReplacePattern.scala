package io.github.chenfh5.leetcode.string


object L0890_FindandReplacePattern {

  import scala.collection.mutable

  // @see https://leetcode.com/problems/find-and-replace-pattern/discuss/161288/C++JavaPython-Normalise-Word
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    val pIdx = norm(pattern)
    val res = mutable.ListBuffer[String]()
    for (word <- words) if (norm(word) sameElements pIdx) res.append(word)
    res.toList
  }

  def norm(str: String) = {
    val map = mutable.HashMap[Char, Int]()
    val res = new Array[Int](str.length)
    for (i <- 0 until str.length) {
      val char = str(i)
      // https://leetcode.com/problems/find-and-replace-pattern/discuss/161288/C++JavaPython-Normalise-Word/168063
      if (!map.contains(char)) map.put(char, map.size) // (char -> char occurrence), only put the first time occurrence
      res(i) = map.get(char).head // first time occurrence index
    }
    res // normalise index only
  }

  def main(args: Array[String]) {
    val words = Array("abc", "deq", "mee", "aqq", "dkd", "ccc")
    val pattern = "abb"
    val res = findAndReplacePattern(words, pattern)
    val expect = List("mee", "aqq")
    print(res)
    assert(res == expect)
  }

}
