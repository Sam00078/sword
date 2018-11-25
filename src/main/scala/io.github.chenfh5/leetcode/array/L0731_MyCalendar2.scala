package io.github.chenfh5.leetcode.array

// @see https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/111433
class MyCalendar2() {

  var books = scala.collection.immutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean = {
    val conflictCnt = 3
    books += (start -> (books.getOrElse(start, 0) + 1)) // entrance-increase
    books += (end -> (books.getOrElse(end, 0) - 1)) // exit-decrease, since right is exclusive, if add it would disturb the real entrance count

    var bookedCnt = 0
    for (book <- books) {
      // since it is the sorted map, it would add the left entry firstly, then minus the right to balance the booked count
      // (1stL,1stR) vs. (2ndL, 2ndR) vs. (3rdL, 3rdR). if 3rdL > 1stR & 3rdL > 2ndR, then booked count would not minus 1 until 3rdL arrival
      bookedCnt += book._2 // the value of one key
      if (bookedCnt == conflictCnt) {
        // reject and rollback
        books += (start -> (books.getOrElse(start, 0) - 1))
        books += (end -> (books.getOrElse(end, 0) + 1))
        return false
      }
    }
    true
  }

}

object L0731_MyCalendar2 {

  def main(args: Array[String]) {
    val myCalendar = new MyCalendar2()
    val res1 = myCalendar.book(10, 20)
    val res2 = myCalendar.book(50, 60)
    val res3 = myCalendar.book(10, 40)
    val res4 = myCalendar.book(5, 15)
    val res5 = myCalendar.book(5, 10)
    val res6 = myCalendar.book(25, 55)
    println(res1)
    println(res2)
    println(res3)
    println(res4)
    println(res5)
    println(res6)
    assert(res1)
    assert(res2)
    assert(res3)
    assert(!res4)
    assert(res5)
    assert(res6)
  }

}
