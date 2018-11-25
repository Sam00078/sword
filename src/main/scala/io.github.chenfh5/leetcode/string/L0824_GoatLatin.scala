package io.github.chenfh5.leetcode.string


object L0824_GoatLatin {

  // @see https://leetcode.com/problems/goat-latin/discuss/127024/C++JavaPython-Straight-Forward-Solution
  def toGoatLatin(S: String): String = {
    import scala.collection.mutable
    val vowel = mutable.HashSet[Char]()
    for (c <- "aeiouAEIOU") vowel.add(c)
    var res = ""
    var i, j = 0
    for (w <- S.split("\\s+")) {
      val ns = if (vowel.contains(w.head)) w else w.substring(1) + w.head
      res += ' ' + ns + "ma"

      j = 0
      i += 1
      while (j < i) {
        res += 'a'
        j += 1
      }
    }
    res.substring(1)
  }

  def main(args: Array[String]) {
    val input = "The quick brown fox jumped over the lazy dog"
    val res = toGoatLatin(input)
    print(res)
    assert(res == "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
  }

}
