package io.github.chenfh5.leetcode

import scala.collection.mutable

object TwoSum_1 {

  /**
    * @see https://leetcode.com/problems/two-sum/description/
    */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val leftMap = mutable.Map[Int, Int]()

    for (i <- 0 until nums.length) {
      val right = nums(i)
      val left = target - right
      if (leftMap.contains(left)) {
        return Array(leftMap(left), i)
      }
      leftMap.put(right, i) // now right become left, since not hit
    }
    throw new IllegalArgumentException("this is the invalid two sum")
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 3, 7, 15)
    val target = 9
    println(twoSum(nums, target).toList)
  }

}
