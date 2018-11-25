package io.github.chenfh5.leetcode.string

import java.util

object L0556_NextGreaterElement3 {

  // @see https://leetcode.com/problems/next-greater-element-iii/discuss/101834/Java(5ms)-Find-Swap-Sort-Solution
  def nextGreaterElement(n: Int): Int = {
    var num = n.toString.toCharArray
    // to find the min greater, from righ to left, find the first right < left, and mark the pos
    for (i <- Range(num.length - 2, 0, -1).inclusive) {
      var minPoi = i
      for (j <- i + 1 until num.length) {
        // find the rightest pos which gt cur i pos
        minPoi = if (num(j) > num(i)) j else minPoi
      }
      if (minPoi != i) {
        val temp = num(i)
        num(i) = num(minPoi)
        num(minPoi) = temp
        util.Arrays.sort(num, i + 1, num.length)
        val res = new String(num).toLong
        return if (res <= Int.MaxValue) res.toInt else -1
      }
    }
    -1
  }

  def main(args: Array[String]) {
    val input = 1234567
    val res = nextGreaterElement(input)
    print(res)
    assert(res==1234576)
  }

}
