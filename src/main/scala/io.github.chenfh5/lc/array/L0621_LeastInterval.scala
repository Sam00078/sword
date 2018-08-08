package io.github.chenfh5.lc.array

object L0621_LeastInterval {

  /**
    * @see https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
    */
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val taskSize = new Array[Int](26) // A -> Z, pos is A, val is its cnt
    var (maxSize, sameMaxCnt) = (0, 0)

    for (task <- tasks) {
      val curTask = task - 'A' // ASCII,(A->65,Z->90,a->97,z->122)
      taskSize(curTask) += 1
      val curTaskSize = taskSize(curTask)

      if (maxSize == curTaskSize) sameMaxCnt += 1
      else if (maxSize < curTaskSize) {
        maxSize = curTaskSize
        sameMaxCnt = 1
      } // maxSize > curTaskSize is normal, then continue
    }

    val splitPart = maxSize - 1
    val splitPartLen = n - (sameMaxCnt - 1)
    val emptySlots = splitPart * splitPartLen // lt 0 means got enough task to fill in each part
    val availableTasks = tasks.length - maxSize * sameMaxCnt
    val idles = math.max(0, emptySlots - availableTasks)

    tasks.length + idles
  }

  def main(args: Array[String]) {
    val tasks = Array('Y', 'A', 'A', 'A', 'C', 'C', 'C', 'D', 'D', 'D', 'B', 'B', 'B', 'Z')
    val res = leastInterval(tasks, 2)
    println(res)
    assert(res == 14) //1+3*4+1
  }

}
