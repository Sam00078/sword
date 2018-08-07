package io.github.chenfh5.lc.array

object L0219_ContainsDuplicate2 {

  /**
    * @see https://leetcode.com/problems/contains-duplicate-ii/discuss/61372/Simple-Java-solution
    */
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val set = scala.collection.mutable.Set[Int]()
    for (i <- 0 until nums.length) {
      if (i > k) set.remove(nums(i - k - 1)) // sliding windows
      if (!set.add(nums(i))) return true
    }
    false
  }

  def main(args: Array[String]) {
    val nums = Array(1, 0, 1, 1)
    val res = containsNearbyDuplicate(nums, 1)
    println(res)
    assert(res)
  }
}
