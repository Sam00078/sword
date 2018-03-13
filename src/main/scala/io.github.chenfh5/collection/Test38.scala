package io.github.chenfh5.collection

/**
  * 统计一个数字在排序数组中出现的次数。
  * 例如输入`排序数组`[1, 2, 3, 3, 3, 3, 4, 5]和数字3，由于3在这个数组中出现了4次，因此输出4。
  */
object Test38 {

  /**
    * @see https://www.jianshu.com/p/4aa00ad1413b
    */
  def getNumberOfTarget(arr: Array[Int], targetNum: Int): Int = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")

    val len = arr.length
    var start = 0
    var end = len - 1
    var mid = 0
    var hitCnt = 0

    //找到第一个targetNum出现在arr的位置x
    var hit = false
    while (start <= end && !hit) {
      mid = (start + end) >> 1 // n/2
      if (arr(mid) == targetNum) hit = true
      else if (arr(mid) < targetNum) start = mid + 1
      else end = mid - 1
    }

    if (start > end) return 0
    //从位置x的左右两边分别遍历
    var indexLeft = mid
    while (indexLeft >= 0 && arr(indexLeft) == targetNum) {
      hitCnt += 1
      indexLeft -= 1
    }

    var indexRight = mid + 1
    while (indexRight < len && arr(indexRight) == targetNum) {
      hitCnt += 1
      indexRight += 1
    }
    hitCnt
  }

  def main(args: Array[String]): Unit = {
    assert(getNumberOfTarget(Array(1, 2, 3, 3, 3, 3, 4, 5), 3) == 4)
    assert(getNumberOfTarget(Array(1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5), 2) == 3)
  }

}
