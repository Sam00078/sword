package io.github.chenfh5.sword1st

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
  * 找出n个整数中最小的k个数
  * topK in N
  *
  * @see http://www.voidcn.com/article/p-qqfbqbhk-qh.html
  *      https://www.jianshu.com/p/2198f276ad2a
  *
  */
object Test30 {

  //暴力法
  def getLeastNumExh(arr: Array[Int], leastNum: Int): List[Int] = {
    if (arr == null || leastNum < 1 || arr.length == 0 || arr.length < leastNum) throw new IllegalArgumentException("invalid input")

    var result = ListBuffer[Int]()
    val arrSort = arr.sortWith(_ < _) //暴力法

    for (i <- 0 until leastNum) {
      result += arrSort(i)
    }
    result.toList
  }

  //大根堆法
  def getLeastNumHeap(arr: Array[Int], leastNum: Int): List[Int] = {
    if (arr == null || leastNum < 1 || arr.length == 0 || arr.length < leastNum) throw new IllegalArgumentException("invalid input")

    var result = ListBuffer[Int]()
    //    val minHeap = mutable.PriorityQueue[Int]()(Ordering[Int].reverse) //小根堆(root最小)
    val maxHeap = mutable.PriorityQueue[Int]()(Ordering[Int]) //大根堆(root最大)
    //
    for (i <- arr) {
      if (maxHeap.size < leastNum) maxHeap.enqueue(i)
      else {
        if (maxHeap.head > i) {
          maxHeap.dequeue()
          maxHeap.enqueue(i)
        }
      }
    }
    //
    while (maxHeap.nonEmpty) {
      result += maxHeap.dequeue()
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val input = Array(4, 5, 1, 6, 2, 7, 3, 8)
    assert(getLeastNumExh(input, 4) == List(1, 2, 3, 4)) //升序
    assert(getLeastNumHeap(input, 4) == List(4, 3, 2, 1)) //逆序
  }

}
