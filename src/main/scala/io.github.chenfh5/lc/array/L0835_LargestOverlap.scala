package io.github.chenfh5.lc.array

object L0835_LargestOverlap {

  // @see https://leetcode.com/problems/image-overlap/discuss/138976/A-generic-and-easy-to-understand-method
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    val (row, col) = (A.length, A.head.length)
    import scala.collection.mutable
    // save the coordinates of one
    val (oneCoordOfA, oneCoordOfB) = (mutable.ListBuffer[Array[Int]](), mutable.ListBuffer[Array[Int]]())
    for (r <- 0 until row) {
      for (c <- 0 until col) {
        if (A(r)(c) == 1) oneCoordOfA += Array(r, c)
        if (B(r)(c) == 1) oneCoordOfB += Array(r, c)
      }
    }
    // count vector from A to B
    val map = mutable.Map[String, Int]()
    for (a <- oneCoordOfA) {
      for (b <- oneCoordOfB) {
        val vectorStr = (a.head - b.head) + " " + (a(1) - b(1)) // get the vector from a pixel in A to a pixel in B
        map.put(vectorStr, map.getOrElse(vectorStr, 0) + 1) // vector increase
      }
    }
    // find the max vector count
    // one map key(vector) means one translate(slide), and we choose the vector of `largest value` to translate
    var max = 0
    for (cnt <- map.values) {
      max = math.max(max, cnt)
    }
    max
  }

  def main(args: Array[String]) {
    val A = Array(Array(1, 1, 0), Array(0, 1, 0), Array(0, 1, 0))
    val B = Array(Array(0, 0, 0), Array(0, 1, 1), Array(0, 0, 1))
    val res = largestOverlap(A, B)
    print(res)
    assert(res == 3)
  }

}
