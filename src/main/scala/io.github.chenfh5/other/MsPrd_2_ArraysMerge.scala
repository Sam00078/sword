package io.github.chenfh5.other

import scala.collection.mutable.ListBuffer

import org.slf4j.LoggerFactory


object MsPrd_2_ArraysMerge {
  private val LOG = LoggerFactory.getLogger(getClass)


  /**
    * @see http://blog.csdn.net/woliuyunyicai/article/details/50364555
    */
  def merge(intervals: List[Interval]): List[Interval] = {
    val res = ListBuffer[Interval]()
    if (intervals == null || intervals.size < 1) return res.toList

    //key point to asc order the intervals
    val sortedIntervals = intervals.sortWith {
      case (a, b) => if (a.start < b.start) true else false
    }

    LOG.debug("this is the     arr = {}", intervals)
    LOG.debug("this is the arrSort = {}", sortedIntervals)
    LOG.debug("this is the arrSort = {}", sortedIntervals.drop(1))

    var prev = sortedIntervals.head
    for (i <- sortedIntervals.drop(1)) {
      if (prev.end >= i.start) prev.end = i.end //合并,pre的右边界跨过了i的左边界
      else { //隔开
        res += prev
        prev = i //重置
      }
    }
    res += prev
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val input1 = List(Interval(15, 18), Interval(1, 3), Interval(2, 6), Interval(8, 10)) //[1,3],[2,6],[8,10],[15,18]
    assert(merge(input1) == List(Interval(1, 6), Interval(8, 10), Interval(15, 18)))

    val input2 = List(Interval(1, 3), Interval(3, 5), Interval(1, 4), Interval(6, 10), Interval(10, 11))
    assert(merge(input2) == List(Interval(1, 5), Interval(6, 11)))

    val input3 = List(Interval(1, 3), Interval(3, 5))
    assert(merge(input3) == List(Interval(1, 5)))

    val input4 = List(Interval(1, 3))
    assert(merge(input4) == List(Interval(1, 3)))
  }

}

case class Interval(
  var start: Int,
  var end: Int
)
