package io.github.chenfh5.leetcode.array

object L0849_MaxDistToClosest {

  /**
    * 1. If the current value is "0", keep going forward.
    * 2. Left pointer points to the position of left "1" and right pointer points to the position of right "1". Keep updating two pointers and calculate the max distance.
    * 3. Be careful of two situations: seats[0] is 0 and seats[len - 1] is 0. Just check them and get the final answer.
    */
  // @see https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/155564/Clean-One-Pass-Two-Pointers-Java-Solution
  def maxDistToClosest(seats: Array[Int]): Int = {
    var (onePosInLeft, max) = (-1, 0)
    for (i <- 0 until seats.length) {
      // If the current value is "0", keep going forward
      if (seats(i) == 1) {
        if (onePosInLeft == -1) max = math.max(max, i) // execute only once
        else max = math.max(max, (i - onePosInLeft) / 2) // distance is the mid of zero
        onePosInLeft = i // update the left one position
      }
    }
    // corner case (10000/00001)
    if (seats.last == 0) max = math.max(max, seats.length - 1 - onePosInLeft)
    max
  }

  def main(args: Array[String]) {
    val seats = Array(1, 0, 0, 0, 1, 0, 1)
    val res = maxDistToClosest(seats)
    print(res)
    assert(res == 2)
  }

}
