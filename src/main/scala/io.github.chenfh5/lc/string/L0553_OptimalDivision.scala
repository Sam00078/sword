package io.github.chenfh5.lc.string

object L0553_OptimalDivision {

  // @see https://leetcode.com/problems/optimal-division/discuss/101687/Easy-to-understand-simple-O(n)-solution-with-explanation
  def optimalDivision(nums: Array[Int]): String = {
    if (nums == null || nums.length < 1) return ""
    if (nums.length == 1) return nums.head.toString
    if (nums.length == 2) return nums.head + "/" + nums(1)

    var res = ""
    for (i <- 0 until nums.length) {
      if (i == 0) res += nums.head + "/("
      else if (i == nums.length - 1) res += nums(i) + ")"
      else res += nums(i) + "/"
    }
    res
  }

  def main(args: Array[String]) {
    val nums = Array(1000, 100, 10, 2)
    val res = optimalDivision(nums)
    print(res)
  }

}
