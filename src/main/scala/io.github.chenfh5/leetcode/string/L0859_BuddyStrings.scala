package io.github.chenfh5.leetcode.string


object L0859_BuddyStrings {

  // @see https://leetcode.com/problems/buddy-strings/discuss/141780/Easy-Understood
  def buddyStrings(A: String, B: String): Boolean = {
    if (A.length != B.length) return false
    // If A == B, we need swap two same characters.
    // unique string can not swap, but duplicated string can swap two same letter to match B
    import scala.collection.mutable
    if (A.equals(B)) {
      val set = mutable.HashSet[Char]()
      for (a <- A) set.add(a)
      return set.size < A.length
    }
    val diffPos = mutable.ListBuffer[Int]()
    for (i <- 0 until A.length) if (A(i) != B(i)) diffPos.append(i)
    diffPos.size == 2 && A(diffPos.head) == B(diffPos.last) && A(diffPos.last) == B(diffPos.head)
  }

  def main(args: Array[String]) {
    val A = "ab"
    val B = "ab"
    val res = buddyStrings(A, B)
    print(res)
  }

}
