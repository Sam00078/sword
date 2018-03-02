package io.github.chenfh5.collection

import scala.collection.mutable.ListBuffer


/**
  * 和为s的两个数字 vs. 和为s的连续正数序列
  *
  * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
  * 例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字 15。由于 4+11 = 15 ，因此输出 4 和 11 。
  *
  * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少两个数）。
  * 例如输入 15，由于 1+2+3+4+5=4＋5+6＝7+8=15，所以结果打出 3 个连续序列 1～5、4～6 和 7～8。
  */

object Test41 {

  def findTwoNumbersWithSum(arr: Array[Int], targetSum: Int): List[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    val twoNumbers = new Array[Int](2)
    var start = 0
    var end = arr.length - 1

    var curSum = 0
    var endLoop = false

    while (start < end && !endLoop) {
      curSum = arr(start) + arr(end)
      if (curSum == targetSum) {
        twoNumbers(0) = arr(start)
        twoNumbers(1) = arr(end)
        endLoop = true
      }
      else if (curSum < targetSum) start += 1
      else end -= 1
    }
    twoNumbers.toList
  }

  /**
    * @see http://blog.csdn.net/zzuchengming/article/details/51057928
    *      http://wiki.jikexueyuan.com/project/for-offer/question-forty-one.html
    */
  def findContinuousSequence(targetNum: Int): List[List[Int]] = {
    var result = ListBuffer[List[Int]]()
    if (targetNum < 3) return result.toList

    var small = 1
    var big = 2
    var curSum = small + big
    val mid = (1 + targetNum) / 2 //small最多能达到的值。因为是2个数组成的和，如果small是中间值，big至少是mid+1的值 n/2+(n+1)/2 > n

    while (small < mid) {
      if (curSum == targetNum) {
        var temp = ListBuffer[Int]()
        for (i <- small to big) {
          temp += i
        }
        result += temp.toList
        curSum -= small //继续右移
        small += 1
      }
      else if (curSum < targetNum) { //若小于，加大big
        big += 1
        curSum += big
      }
      else { //若大于，减掉small，再small右移一位
        curSum -= small
        small += 1
      }
    }
    result.toList
  }


  def main(args: Array[String]): Unit = {
    val input = Array(1, 2, 4, 7, 11, 15)
    assert(findTwoNumbersWithSum(input, 15) == List(4, 11))
    println()

    println(findContinuousSequence(1))
    assert(findContinuousSequence(3) == List(List(1, 2)))
    println(findContinuousSequence(4))
    println(findContinuousSequence(9))
    assert(findContinuousSequence(15) == List(List(1, 2, 3, 4, 5), List(4, 5, 6), List(7, 8)))
    println(findContinuousSequence(100))
  }

}
