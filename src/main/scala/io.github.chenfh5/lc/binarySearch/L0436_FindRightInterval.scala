package io.github.chenfh5.lc.binarySearch


object L0436_FindRightInterval {

  // @see https://leetcode.com/problems/find-right-interval/discuss/91789/Java-clear-O(n-logn)-solution-based-on-TreeMap
  def findRightInterval(intervals: Array[Interval]): Array[Int] = {
    val len = intervals.length
    val res = Array.ofDim[Int](len)
    var map = scala.collection.immutable.TreeMap[Int, Int]()
    for (i <- 0 until len) map += (intervals(i).start -> i) // put left

    for (i <- 0 until len) {
      val entry = map.from(intervals(i).end).headOption // bigger than or equal. find left using right
      res(i) = if (entry.isDefined) entry.get._2 else -1
    }
    res
  }

  def main(args: Array[String]) {
    val intervals = Array(Interval(3, 4), Interval(2, 3), Interval(1, 2))
    val res = findRightInterval(intervals)
    print(res.toList)
    assert(res sameElements Array(-1, 0, 1))
  }

  case class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
  }

}

