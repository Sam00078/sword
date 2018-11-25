package io.github.chenfh5.leetcode.string

import scala.collection.mutable

object L0767_ReorganizeString {

  // @see https://leetcode.com/problems/reorganize-string/discuss/113440/Java-solution-PriorityQueue/114521
  def reorganizeString(S: String): String = {
    // initial map
    val cntMap = new Array[Int](26)
    for (i <- 0 until S.length) {
      cntMap(S(i) - 'a') += 1
    }

    // initial pq
    val arrayOrdering = new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(1) > y(1)) 1 // reverse order in compare with `letter frequency`
        else if (x(1) == y(1)) 0
        else -1
      }
    }
    val pq = new mutable.PriorityQueue[Array[Int]]()(arrayOrdering)
    for (i <- 0 until 26) {
      if (cntMap(i) != 0) {
        pq.enqueue(Array(i, cntMap(i))) // letter -> letterCnt
      }
    }
    // loop
    var prev = Array(-1, 0)
    val sb = new StringBuilder()
    while (pq.nonEmpty) {
      val curr = pq.dequeue()
      if (prev(1) > 0) pq.enqueue(prev) // add the last used letter back, make sure the more frequency in the head
      sb.append((curr.head + 'a').toChar)
      curr(1) -= 1
      prev = curr
      if (pq.isEmpty && prev(1) > 0) return ""
    }
    sb.toString()
  }

  def reverse() = {
    val arrayOrdering = new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x.head > y.head) 1 // reverse order
        else if (x.head == y.head) 0
        else -1
      }
    }
    val pq = pqFit(arrayOrdering)

    while (pq.nonEmpty) {
      println(pq.dequeue().toList)
    }
  }

  def normal() = {
    val arrayOrdering = new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x.head > y.head) -1 // normal order
        else if (x.head == y.head) 0
        else 1
      }
    }
    val pq = pqFit(arrayOrdering)

    while (pq.nonEmpty) {
      println(pq.dequeue().toList)
    }
  }

  def pqFit(arrayOrdering: Ordering[Array[Int]]) = {
    // @see https://www.scala-lang.org/old/node/9021.html#comment-38373
    val pq = new mutable.PriorityQueue[Array[Int]]()(arrayOrdering)
    pq.enqueue(Array(2, 3, 4, 5))
    pq.enqueue(Array(3, 4, 5, 6))
    pq.enqueue(Array(1, 2, 3, 4))
    pq
  }

  def main(args: Array[String]) {
    // self test
    reverse()
    println("----")
    normal()

    // leetcode
    val input = "aab"
    val res = reorganizeString(input)
    print(res)
    assert(res == "aba")
  }

}
