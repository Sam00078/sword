package io.github.chenfh5.lc


object L0056_MergeIntervals {

  /**
    * @see https://leetcode.com/problems/merge-intervals/discuss/155683/Beat-100-short-solution-Scala
    */
  def merge(intervals: List[Interval]): List[Interval] = {
    val sortedIntervals = intervals.sortWith(_.start < _.start)
    import scala.collection.mutable.ListBuffer
    val res = ListBuffer[Interval]()

    for (i <- sortedIntervals) {
      if (res.nonEmpty && i.start <= res.last.end) //当前i的start在最新res的end里,合并.接着看取哪个end作为end
        res.last.end = math.max(i.end, res.last.end)
      else
        res += i
    }
    res.toList
  }

  def main(args: Array[String]) {
    val input = List(Interval(1, 4), Interval(4, 5))
    val res = merge(input)
    println(res)
    assert(res == List(Interval(1, 5)))
  }

}

case class Interval(
  var start: Int,
  var end: Int
)

