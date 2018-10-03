package io.github.chenfh5.lc.twoPointers

object L0567_PermutationinString {

  // @see https://leetcode.com/problems/permutation-in-string/discuss/102640/Simple-and-clear-Java-solution
  def checkInclusion(s1: String, s2: String): Boolean = {
    val arr1, arr2 = new Array[Int](26) // The input strings only contain lower case letters. This writing style would get two different array
    for (char <- s1) arr1(char - 'a') += 1
    val len1 = s1.length
    for (i <- 0 until s2.length) {
      arr2(s2(i) - 'a') += 1 // a~z
      if (i >= len1) arr2(s2(i - len1) - 'a') -= 1 // make sure arr2 put size equal len1, but the order not necessary
      if (arr1.sameElements(arr2)) return true
    }
    false
  }

  def main(args: Array[String]) {
    val res = checkInclusion("ab", "eidbaooo")
    print(res)
    assert(res)
  }

}
