package io.github.chenfh5.lc.array

object L0769_MaxChunksToSorted {

  // TODO
  // @see https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113462/Java-solution-left-max-and-right-min.
  // from left to right, then form the right to left and find the first j that num(j-1) >= num(j)
  def maxChunksToSorted(arr: Array[Int]): Int = {
    val len = arr.length
    val (leftMax, rightMin) = (new Array[Int](len), new Array[Int](len)) // the max/min till now

    leftMax(0) = arr.head
    for (i <- 1 until len) leftMax(i) = math.max(leftMax(i - 1), arr(i))

    rightMin(len - 1) = arr.last
    for (i <- Range(len - 2, 0, -1).inclusive) rightMin(i) = math.min(rightMin(i + 1), arr(i))

    var res = 0
    // 以ori=4,3,2,5,5来看,要判断是从4还是从3还是从2断开,要看当前为止后面有没有比当前值还小的存在,如果有更小的,需要将其包裹在一起来sort
    for (i <- 0 until len - 1) {
      if (leftMax(i) <= rightMin(i + 1)) res += 1 // 当前为止的后面已经没有了比当前还小的值了,所以在此断开. equal use to control max chunk len or min chunk len
    }
    res + 1
  }

  // 2,1,3,4,4(ori)
  // 2,2,3,4,4(leftMax)
  // 1,1,3,4,4(rightMin)
  // 21,3,4,4(res)
  def main(args: Array[String]) {
    val arr = Array(2, 1, 3, 4, 4)
    val res = maxChunksToSorted(arr)
    print(res)
    assert(res == 4)
  }

}
