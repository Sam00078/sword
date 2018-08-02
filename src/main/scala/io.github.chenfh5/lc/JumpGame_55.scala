package io.github.chenfh5.lc

object JumpGame_55 {

  /**
    * @see https://leetcode.com/problems/jump-game/discuss/20932/6-line-java-solution-in-O(n)
    *      greed, max all the time
    */
  def canJump(nums: Array[Int]): Boolean = {
    var alreadyStep = 0
    for (i <- 0 until nums.length) {
      if (i > alreadyStep) return false // if already step behind current index, then fail
      alreadyStep = math.max(alreadyStep, i + nums(i)) // max already go step within the furthest
    }
    true
  }

  def main(args: Array[String]) {
    val nums = Array(3, 2, 1, 0, 4)
    val jumped = canJump(nums)
    println(jumped)
  }

}
