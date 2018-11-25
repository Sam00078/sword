package io.github.chenfh5.leetcode.array

object L0004_FindMedianSortedArrays {

  /**
    * @see https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation/141440
    */
  // TODO: find more elegant and readable code from other authors' submission
  def findMedianSortedArrays(num1: Array[Int], num2: Array[Int]): Double = {
    import scala.math.{max, min}
    val (small, big) = if (num1.length > num2.length) (num2, num1) else (num1, num2) // make sure bigger in right
    val (smallLen, bigLen) = (small.length, big.length)

    // range of small cut location: smallLen means no right half for small
    var (low, high) = (0, smallLen)
    while (low <= high) {
      val smallMid = (low + high) / 2 // mid location is counted to right half
      val bigMid = (smallLen + bigLen) / 2 - smallMid

      val smallLeft = if (smallMid == 0) Int.MinValue else small(smallMid - 1)
      val smallRight = if (smallMid == smallLen) Int.MaxValue else small(smallMid)
      val bigLeft = if (bigMid == 0) Int.MinValue else big(bigMid - 1)
      val bigRight = if (bigMid == bigLen) Int.MaxValue else big(bigMid)

      if (smallLeft > bigRight) high = smallMid - 1
      else if (bigLeft > smallRight) low = smallMid + 1
      else return if ((smallLen + bigLen) % 2 == 1) min(smallRight, bigRight) else (max(smallLeft, bigLeft) + min(smallRight, bigRight)) / 2.0
    }
    throw new IllegalArgumentException("this is the invalid input")
  }

  def mergeSort(num1: Array[Int], num2: Array[Int]): Double = {
    val nums = (num1 ++ num2).sortWith(_ < _)
    val isOdd = if (nums.length % 2 == 0) false else true
    val len = nums.length
    if (isOdd) nums(len / 2) else (nums(len / 2 - 1) + nums(len / 2)) / 2.0
  }

  def main(args: Array[String]): Unit = {
    val num1 = Array(1, 2)
    val num2 = Array(3, 4)
    println(findMedianSortedArrays(num1, num2))
    assert(findMedianSortedArrays(num1, num2) == mergeSort(num1, num2))
  }

}
