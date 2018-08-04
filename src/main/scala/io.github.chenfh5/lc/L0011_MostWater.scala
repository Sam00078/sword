package io.github.chenfh5.lc

object L0011_MostWater {

  /**
    * @see https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
    */
  def maxArea(height: Array[Int]): Int = {
    if (height == null || height.length == 0) return 0

    var leftPos = 0
    var rightPos = height.length - 1
    var maxArea = 0
    while (leftPos < rightPos) {
      val newArea = math.min(height(leftPos), height(rightPos)) * (rightPos - leftPos)
      maxArea = math.max(maxArea, newArea)
      if (height(leftPos) > height(rightPos)) rightPos -= 1
      else leftPos += 1
    }
    maxArea
  }

  def main(args: Array[String]): Unit = {
    val height = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(s"maxArea= ${maxArea(height)}")
    assert(maxArea(height) == 49)
  }

}
