package io.github.chenfh5.leetcode.string


object L0049_GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    import scala.collection.mutable
    val map = mutable.Map[String, mutable.ListBuffer[String]]()

    for (str <- strs) {
      val key = str.sortWith(_ < _) // sort key to get rid of the order difference
      if (map.contains(key)) map.get(key).head.append(str)
      else map.put(key, mutable.ListBuffer(str))
    }
    map.values.map(e => e.toList).toList
  }

  // @see https://leetcode.com/submissions/detail/170578904/
  def groupAnagrams2(strs: Array[String]): List[List[String]] = {
    strs.toList.groupBy(_.sorted).values.toList
  }

  def main(args: Array[String]) {
    val strs = Array("eat", "tea", "tan", "ate", "nat", "bat")
    val res = groupAnagrams(strs)
    print(res)
    val expect = List(List("bat"), List("eat", "tea", "ate"), List("tan", "nat"))
    assert(res == expect)
  }

}
