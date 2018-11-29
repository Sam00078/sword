package io.github.chenfh5.leetcode.array

object L0167_TwoSum2 {

  // @see https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/51239/Share-my-java-AC-solution.
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    val oriArr = Array(0, 0)
    if (numbers == null || numbers.length < 2) return oriArr
    var (left, right) = (0, numbers.length - 1)
    while (left < right) {
      val sum = numbers(left) + numbers(right)
      if (sum == target) {
        return Array(left + 1, right + 1)
      } else if (sum > target) right -= 1
      else left += 1
    }
    oriArr
  }

  def main(args: Array[String]) {
    val numbers = Array(2, 7, 11, 15)
    val res = twoSum(numbers, 9)
    println(res.toList)
    assert(res sameElements Array(1, 2))
  }

}
