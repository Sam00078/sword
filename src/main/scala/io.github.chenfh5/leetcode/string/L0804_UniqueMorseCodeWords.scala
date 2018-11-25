package io.github.chenfh5.leetcode.string

object L0804_UniqueMorseCodeWords {

  // @see https://leetcode.com/problems/unique-morse-code-words/discuss/120675/C++JavaPython-Easy-and-Concise-Solution
  def uniqueMorseRepresentations(words: Array[String]): Int = {
    import scala.collection.mutable
    val dict = Array(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
    val set = mutable.HashSet[String]()
    for (word <- words) {
      var code = ""
      for (c <- word) code += dict(c - 'a')
      set.add(code) // lt words.length
    }
    set.size
  }

  def main(args: Array[String]) {
    val input = Array("gin", "zen", "gig", "msg")
    val res = uniqueMorseRepresentations(input)
    print(res)
    assert(res == 2)
  }

}
