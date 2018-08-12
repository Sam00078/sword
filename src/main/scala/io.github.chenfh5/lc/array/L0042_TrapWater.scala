package io.github.chenfh5.lc.array

object L0042_TrapWater {

  /**
    * @see https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution./17215
    */
  def trap(height: Array[Int]): Int = {
    import math.max
    var trapedWater = 0
    if (height == null || height.length < 3) return trapedWater
    var (leftMaxHeight, rightMaxHeight) = (height.head, height.last)
    var (leftPos, rightPos) = (1, height.length - 2)

    while (leftPos <= rightPos) {
      if (leftMaxHeight < rightMaxHeight) {
        leftMaxHeight = max(leftMaxHeight, height(leftPos))
        trapedWater += leftMaxHeight - height(leftPos) // if leftMaxHeight in the left then would store
        leftPos += 1
      } else {
        rightMaxHeight = max(rightMaxHeight, height(rightPos))
        trapedWater += rightMaxHeight - height(rightPos)
        rightPos -= 1
      }
    }
    trapedWater
  }

  def main(args: Array[String]) {
    val height = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    val trapedWater = trap(height)
    println(s"trapedWater = $trapedWater")
    assert(trapedWater == 6)
  }

}
