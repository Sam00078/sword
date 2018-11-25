package io.github.chenfh5.leetcode.string

object L0551_StudentAttendanceRecord {

  // @see https://leetcode.com/problems/student-attendance-record-i/discuss/101599/Java-O(N)-solution-Accepted
  def checkRecord(s: String): Boolean = {
    val (charA, charL) = ('A', 'L')
    var (countA, countL) = (0, 0)
    for (i <- 0 until s.length) {
      val curChar = s(i)
      if (curChar == charA) {
        countA += 1
        countL = 0 // reset
      }
      else if (curChar == charL) countL += 1
      else countL = 0 // reset

      if (countA > 1 || countL > 2) return false
    }
    true
  }

  // @see https://leetcode.com/submissions/detail/170814695/
  def checkRecord2(s: String): Boolean = {
    s.count(_.equals('A')) < 2 && !s.contains("LLL")
  }

  def main(args: Array[String]) {
    val s = "PPALLL"
    val res = checkRecord(s)
    print(res)
    assert(!res)
  }

}
