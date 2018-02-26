package io.github.chenfh5.collection

object Test29 {

  def findTargetNum(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1) throw new RuntimeException("invalid array size")

    var targetNum = arr.head
    var count = 0

    //找出最多的targetNum
    for (i <- arr.slice(1, arr.length)) {
      if (count == 0) {
        targetNum = i
        count = 1
      }
      else if (targetNum == i) count += 1
      else count -= 1
    }

    //
    count = 0
    for (i <- arr) {
      if (targetNum == i) count += 1
    }

    //
    if (count > arr.length / 2) targetNum
    else throw new IllegalArgumentException("invalid input array")
  }

  def main(args: Array[String]): Unit = {
    val inputArray = Array(1, 2, 3, 2, 2, 2, 5, 4, 2)
    assert(findTargetNum(inputArray) == 2)
  }

}
