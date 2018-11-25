package io.github.chenfh5.leetcode.twoPointers

object L0838_PushDominoes {

  // @see https://leetcode.com/problems/push-dominoes/discuss/132330/funny-idea-but-passed-within-time-limit-(Python)/139390
  def pushDominoes(dominoes: String): String = {
    var (s1, notDone) = (dominoes, true)
    val patten1 = "R.L" // fix
    val patten2 = ".L" // fall to the left
    val patten3 = "R." // fall to the right
    val patten0 = "X" // temp

    while (notDone) {
      var s2 = s1
      if (s2.contains(patten1)) s2 = s2.replace(patten1, patten0)
      if (s2.contains(patten2)) s2 = s2.replace(patten2, "LL")
      if (s2.contains(patten3)) s2 = s2.replace(patten3, "RR")
      if (s2 == s1) notDone = false // if the dealed str eq raw srt
      s1 = s2 // use to new str to be loop next time
    }
    s1.replaceAll(patten0, "R.L")
  }

  // TODO: TLE
  def main(args: Array[String]) {
//    val s1 = ".L.R...LR..L.."
    val s1 = "......LLL.RRRL.R...L..LR...L......RLR"
    val res = pushDominoes(s1)
    print(res)
//    assert(res == "LL.RR.LLRRLL..")
  }

}
