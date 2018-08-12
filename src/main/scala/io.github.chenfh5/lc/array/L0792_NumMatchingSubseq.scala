package io.github.chenfh5.lc.array


object L0792_NumMatchingSubseq {

  // @see https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue
  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    import scala.collection.mutable
    val map = mutable.Map[Char, mutable.Queue[String]]()
    // initial
    for (char <- 'a' to 'z') {
      // All words in words and S will only consists of lowercase letters.
      map.put(char, mutable.Queue[String]())
    }
    // set the words
    for (word <- words) {
      map.get(word.head) match {
        case Some(queue) => queue += word
        case None => map.put(word.head, mutable.Queue[String]())
      }
    }
    // count the S
    // inverse mind. Not use the each word to match the small S
    // but loop the small S to rm each word
    var count = 0
    for (char <- S) {
      val curWordsQueue = map.get(char).head
      val size = curWordsQueue.size
      for (i <- 0 until size) {
        val word = curWordsQueue.dequeue() // empty or one word or many word
        // the last char without remain. char is in S, since the char from S
        if (word.length <= 1) count += 1
        // remain subWord, since it is in S-loop, so it has take the order of each word into account
        // if the subWord occur in the char(from S), that order is valid
        else map.get(word(1)).head += word.substring(1)
      }
    }
    // return
    count
  }

  def main(args: Array[String]) {
    val (s, words) = ("abxcde", Array("a", "bb", "acd", "ace"))
    val res = numMatchingSubseq(s, words)
    print(res)
    assert(res == 3)
  }

}
