package io.github.chenfh5.leetcode.twoPointers

object L0003_LengthOfLongestSubstring {

  // @see https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
  def lengthOfLongestSubstring(s: String): Int = {
    var (max, curUniqSubStrBegin) = (0, 0)
    val map = scala.collection.mutable.Map[Char, Int]()
    for (i <- 0 until s.length) {
      val curChar = s(i)
      if (map.contains(curChar)) curUniqSubStrBegin = math.max(curUniqSubStrBegin, map.get(curChar).head + 1) // repeat char occur. in case of abba, a is final. curUniqSubStrBegin = (1+1->ba) not (0+1->bba). @see https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation/145450
      map.put(curChar, i) // record the newly position
      max = math.max(max, i - curUniqSubStrBegin + 1)
    }
    max
  }

  def main(args: Array[String]): Unit = {
    val s = "pwwkew"
    val res = lengthOfLongestSubstring(s)
    print(res)
    assert(res == 3)
  }

}
