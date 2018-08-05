package io.github.chenfh5.lc


object L0228_SummaryRanges {

  def summaryRanges(nums: Array[Int]): List[String] = {
    nums match {
      case _ if nums == null || nums.length < 1 => List()
      case _ if nums.length < 2 => List(nums.head.toString)
      case _ =>
        val temp = scala.collection.mutable.ListBuffer[String]()
        val res = scala.collection.mutable.ListBuffer[String]()
        val numsLen = nums.length

        for (i <- 0 until numsLen) {
          temp.append(nums(i).toString)
          if (i >= numsLen - 1 || nums(i + 1) != nums(i) + 1) {
            if (temp.length < 2) res.append(temp.head)
            else res.append(temp.head + "->" + temp.last)
            temp.clear()
          }
        }
        res.toList
    }
  }


  def main(args: Array[String]) {
    val nums = Array(0, 2, 3, 4, 6, 8, 9)
    val res = summaryRanges(nums)
    println(res)
    assert(res == List("0", "2->4", "6", "8->9"))
  }
}
