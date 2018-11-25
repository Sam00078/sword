package io.github.chenfh5.leetcode.array


// @see http://leetcode.com/problems/my-calendar-i/discuss/109462/Java-8-liner-TreeMap/113890
// @see https://leetcode.com/submissions/detail/168780861/
class MyCalendar1() {

  var books = scala.collection.immutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean = {
    val maxLowltEnd = books.until(end).lastOption // fetch key lt end (not equal)
    val insert = maxLowltEnd match {
        case Some((_, e)) => if (e <= start) true else false // equal, since right is exclusive
        case None => true
      }
    if (insert) books += (start -> end)
    insert
  }

}

class MyCalendar1InspiredByCalendar2Solution() {

  var books = scala.collection.immutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean = {
    val conflictCnt = 2
    books += (start -> (books.getOrElse(start, 0) + 1)) // entrance-increase
    books += (end -> (books.getOrElse(end, 0) - 1)) // exit-decrease, since right is exclusive, if add it would disturb the real entrance count

    var bookedCnt = 0
    for (book <- books) {
      // since it is the sorted map, it would add the left entry firstly, then minus the right to balance the booked count
      // (1stL,1stR) vs. (2ndL, 2ndR) vs. (3rdL, 3rdR). if 3rdL > 1stR & 3rdL > 2ndR, then booked count would not minus 1 until 3rdL arrival
      bookedCnt += book._2
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

object L0729_MyCalendar1 {

  def main(args: Array[String]) {
    val myCalendar = new MyCalendar1InspiredByCalendar2Solution()
    val res1 = myCalendar.book(10, 20)
    val res2 = myCalendar.book(15, 25)
    val res3 = myCalendar.book(20, 30)
    println(res1)
    println(res2)
    println(res3)
    assert(res1)
    assert(!res2)
    assert(res3)
  }

}
