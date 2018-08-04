package io.github.chenfh5.lc

object L0027_RemoveElement {

  /**
    * @see https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re
    *      be careful to modification when iterating
    *      with the first five elements of nums containing 0, 1, 3, 0, and 4.
    */
  def removeElement(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.length == 0) return 0

    var diffPos = 0
    for (i <- 0 until nums.length) {
      if (nums(i) != target) { // replace with diffPos when not equal to the target
        nums(diffPos) = nums(i)
        diffPos += 1
      }
    }
    println(nums.toList)
    diffPos
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 1, 2, 2, 3, 0, 4, 2)
    val target = 2
    assert(removeElement(nums, target) == 5) // 0, 1, 3, 0, 4, ...
  }

}
