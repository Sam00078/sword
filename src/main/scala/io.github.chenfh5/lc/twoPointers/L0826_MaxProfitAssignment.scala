package io.github.chenfh5.lc.twoPointers

object L0826_MaxProfitAssignment {

  // @see https://leetcode.com/problems/most-profit-assigning-work/discuss/127031/C++JavaPython-Sort-and-Two-pointer
  def maxProfitAssignment(difficulty: Array[Int], profit: Array[Int], worker: Array[Int]): Int = {
    val jobs = scala.collection.mutable.ListBuffer[(Int, Int)]()
    val len = profit.length
    for (i <- 0 until len) jobs.append((difficulty(i), profit(i))) // diff and prof are 1-1 match
    // if sort then no need to find again from head
    val sortJobs = jobs.sortWith(_._1 < _._1)
    val sortWorker = worker.sortWith(_ < _)

    var i, maxProf, res = 0
    for (ability <- sortWorker) {
      while (i < len && ability >= sortJobs(i)._1) {
        maxProf = math.max(maxProf, sortJobs(i)._2)
        i += 1
      }
      res += maxProf
    }
    res
  }

  def main(args: Array[String]) {
    val difficulty = Array(2, 4, 6, 8, 10)
    val profit = Array(10, 20, 30, 40, 50)
    val worker = Array(5, 6, 4, 7)
    val res = maxProfitAssignment(difficulty, profit, worker)
    print(res)
    assert(res == 100)
  }

}
