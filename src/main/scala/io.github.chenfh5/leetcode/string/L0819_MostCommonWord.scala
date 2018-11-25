package io.github.chenfh5.leetcode.string


object L0819_MostCommonWord {

  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val bannedSet = banned.toSet
    import scala.collection.mutable
    val letterCnt = mutable.HashMap[String, Int]()
    val words = paragraph.replaceAll("\\W+", " ").toLowerCase.split("\\s+") //w(lower) means `letter+digital`, W(upper) mean not `letter+digital`
    for (word <- words) {
      if (!bannedSet.contains(word)) letterCnt.put(word, letterCnt.getOrElse(word, 0) + 1)
    }
    letterCnt.maxBy(_._2)._1
  }

  def main(args: Array[String]) {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = Array("hit")
    val res = mostCommonWord(paragraph, banned)
    print(res)
    assert(res == "ball")
  }

}
