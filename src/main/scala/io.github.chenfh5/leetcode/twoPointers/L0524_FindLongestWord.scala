package io.github.chenfh5.leetcode.twoPointers

object L0524_FindLongestWord {

  // @see https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/discuss/99588/Short-Java-Solutions-Sorting-Dictionary-and-Without-Sorting/103703
  def findLongestWord(s: String, d: List[String]): String = {
    var res = ""
    for (word <- d) {
      if (isSubseqOfStr(word, s)) {
        if (word.length > res.length) res = word // get Longest length
        if (word.length == res.length && word < res) res = word // get smallest lexicographical order
      }
    }
    res
  }

  // check the word is the subseq of str
  @inline
  def isSubseqOfStr(word: String, str: String): Boolean = {
    var (i, j) = (0, 0)
    while (i < word.length && j < str.length) {
      if (word(i) == str(j)) i += 1 // word if in str then step forward
      j += 1 // str always step forward
    }
    i == word.length
  }

  def main(args: Array[String]) {
    val (s, d) = ("abpcplea", List("ale", "apple", "monkey", "plea"))
    val res = findLongestWord(s, d)
    print(res)
    assert(res == "apple")
  }

}
