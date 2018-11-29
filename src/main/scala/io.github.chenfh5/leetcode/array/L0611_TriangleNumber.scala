package io.github.chenfh5.leetcode.array

object L0611_TriangleNumber {

  // @see https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
  def triangleNumber(nums: Array[Int]): Int = {
    val sortedNums = nums.sortWith(_ < _)
    val len = nums.length
    var count = 0
    // from right to left, that is convenient to find the max edge
    for (i <- Range(len - 1, 1, -1)) {
      var (left, right) = (0, i - 1)
      while (left < right) {
        if (sortedNums(left) + sortedNums(right) > sortedNums(i)) {
          count += right - left // cover the range since haven been sorted
          right -= 1
        } else left += 1
      }
    }
    count
  }

  // @see https://leetcode.com/submissions/detail/168129897/
  def triangleNumber2(nums: Array[Int]): Int = {
    val len = nums.length
    var cnt = 0
    // i is max, k is min (i > j > k)
    for (i <- 2 until len; j <- 1 until i; k <- 0 until j) {
      val a = nums(i)
      val b = nums(j)
      val c = nums(k)
      if (a > 0 && b > 0 && c > 0 &&
        a + b > c &&
        b + c > a &&
        a + c > b) {
        cnt += 1
      }
    }
    cnt
  }

  def main(args: Array[String]) {
    val nums = Array(2, 2, 3, 4)
    val res = triangleNumber2(nums)
    println(res)
    assert(res == 3)
  }
}
