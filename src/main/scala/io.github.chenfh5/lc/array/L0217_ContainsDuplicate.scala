package io.github.chenfh5.lc.array

object L0217_ContainsDuplicate {

  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums match {
      case _ if nums == null || nums.length < 1 => false
      case _ =>
        val set = scala.collection.mutable.Set[Int]()
        for (num <- nums) {
          if (!set.add(num)) return true // `true` if the element was not yet present in the set, `false` otherwise
        }
        false
    }
  }

  def main(args: Array[String]) {
    val nums = Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
    val res = containsDuplicate(nums)
    println(res)
    assert(res)
  }


}
