package io.github.chenfh5.lc


object L0084_LargestRectangleArea {

  /**
    * @see leetcode.com/problems/largest-rectangle-in-histogram/discuss/29010/My-modified-answer-from-GeeksforGeeks-in-JAVA/27903
    */
  def largestRectangleArea(heights: Array[Int]): Int = {
    if (heights == null || heights.length < 1) return 0

    var maxArea = 0
    import scala.collection.mutable
    val stack = mutable.Stack[Int]()
    for (i <- 0 to heights.length) {
      // if the height of left taller than right need to adjust, else append the right to the stack until the last element to make it the width
      while (stack.nonEmpty && (i == heights.length || heights(stack.top) >= heights(i))) {
        val h = heights(stack.pop())
        val w = if (stack.isEmpty) i else i - stack.top - 1
        maxArea = math.max(maxArea, h * w)
      }
      stack.push(i)
    }
    maxArea
  }

  def main(args: Array[String]) {
    val heights = Array(2, 1, 5, 6, 2, 3)
    val res = largestRectangleArea(heights)
    println(res)
    assert(res == 10)
  }

}
