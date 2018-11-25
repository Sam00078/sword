package io.github.chenfh5.leetcode.array

object L0713_NumSubarrayProductLessThanK {

  // @see https://leetcode.com/problems/subarray-product-less-than-k/discuss/108832/Straightforward-Solution/110942
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    if (k == 0) return 0
    var (count, product, left, right) = (0, 1, 0, 0)
    while (right < nums.length) {
      product *= nums(right)
      right += 1
      while (product >= k && left < right) {
        // kick most-left
        product /= nums(left)
        left += 1
      }
      count += right - left
    }
    count
  }

  def main(args: Array[String]) {
    val nums = Array(10, 5, 2, 6)
    val res = numSubarrayProductLessThanK(nums, 100)
    print(res)
    assert(res == 8)
  }

}
