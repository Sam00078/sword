package io.github.chenfh5.lc.binarySearch

object L0410_SplitArrayLargestSum {

  // @see https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation:-8ms-Binary-Search-Java
  def splitArray(nums: Array[Int], m: Int): Int = {
    var (max, sum) = (0, 0)
    for (num <- nums) {
      max = math.max(max, num)
      sum += num
    }
    if (m == 1) return sum
    // binary search
    var (l, r) = (max, sum) // since l is at least one part, and only max could be one part alone
    while (l < r) {
      val mid = l + (r - l) / 2
      if (valid(mid, nums, m)) r = mid // already pick but still too many cut. therefore to narrow down the high
      else l = mid + 1
    }
    l
  }

  @inline
  def valid(mid: Int, nums: Array[Int], m: Int): Boolean = {
    var (count, total) = (1, 0)
    for (num <- nums) {
      total += num
      if (total > mid) {
        count += 1
        total = num // reset total for another new part
        if (count > m) return false
      }
    }
    true
  }

  def main(args: Array[String]) {
    val nums = Array(7, 2, 5, 10, 8)
    val res = splitArray(nums, 2)
    print(res)
    assert(res == 18)
  }

}
