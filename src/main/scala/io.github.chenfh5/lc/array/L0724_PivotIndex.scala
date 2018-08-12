package io.github.chenfh5.lc.array

object L0724_PivotIndex {

  // @see https://leetcode.com/problems/find-pivot-index/discuss/109249/Java-6-liner/111275
  def pivotIndex(nums: Array[Int]): Int = {
    var (sumLeft, sumAll) = (0, nums.sum)

    // without itself,(1,7,3)-(6)-(6,5,6), 6 is pivot, sumLeft = sumRight = 11
    for (i <- 0 until nums.length) {
      if (sumLeft * 2 + nums(i) == sumAll) return i
      sumLeft += nums(i)
    }
    -1
  }

  def main(args: Array[String]) {
    val nums = Array(1, 7, 3, 6, 5, 6)
    val res = pivotIndex(nums)
    print(res)
    assert(res == 3)
  }

}
