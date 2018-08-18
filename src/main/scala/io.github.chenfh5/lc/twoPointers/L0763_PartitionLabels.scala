package io.github.chenfh5.lc.twoPointers


object L0763_PartitionLabels {


  // @see https://leetcode.com/problems/partition-labels/discuss/113259/Java-2-pass-O(n)-time-O(1)-space-extending-end-pointer-solution
  def partitionLabels(S: String): List[Int] = {
    val map = new Array[Int](26)
    for (i <- 0 until S.length) map(S(i) - 'a') = i // record the last index of the each char

    // record the end index of the current sub string
    val res = scala.collection.mutable.ListBuffer[Int]()
    var curPartLeftPos, maxRight = 0
    for (j <- 0 until S.length) {
      val char = S(j)
      maxRight = math.max(maxRight, map(char - 'a'))
      if (j == maxRight) {
        res.append(j - curPartLeftPos + 1)
        curPartLeftPos = maxRight + 1
      }
    }
    res.toList
  }

  def main(args: Array[String]) {
    val res = partitionLabels("ababcbacadefegdehijhklij")
    print(res)
    assert(res == List(9, 7, 8))
  }

}
