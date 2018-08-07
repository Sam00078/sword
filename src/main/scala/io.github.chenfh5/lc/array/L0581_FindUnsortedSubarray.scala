package io.github.chenfh5.lc.array

object L0581_FindUnsortedSubarray {

  /**
    * @see https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
    */
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    var (len, begin, end, rightMin, leftMax) = (nums.length, 1, 0, nums.last, nums.head)
    // 遍历所有直到分别找到左侧的最小和右侧的最大.
    for (i <- 1 until nums.length) {
      leftMax = math.max(leftMax, nums(i)) // from left to find the biggest
      if (leftMax > nums(i)) end = i // if preMax > nums, then yes

      rightMin = math.min(rightMin, nums(len - 1 - i)) // from right to find the smallest
      if (rightMin < nums(len - 1 - i)) begin = len - 1 - i // if preMin < nums, then yes
    }
    end - begin + 1
  }

  def main(args: Array[String]) {
    val nums = Array(2, 6, 4, 8, 10, 9, 15)
    val res = findUnsortedSubarray(nums)
    println(res)
    assert(res == 5)
  }

}
