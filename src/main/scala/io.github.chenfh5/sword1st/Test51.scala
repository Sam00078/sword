package io.github.chenfh5.sword1st

import scala.collection.mutable


/**
  * 在一个长度为n的数组里的所有数字都在`0到n-1`的范围内。
  * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
  * 请找出数组中任意一个重复的数字。
  */
object Test51 {

  def findDuplicateHash(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1 || arr.min < 0 || arr.max > arr.length - 1) return -1 /*throw new IllegalArgumentException("invalid input array")*/

    val set = mutable.HashSet[Int]()
    for (i <- arr) {
      if (set.contains(i)) return i
      else set.add(i)
    }
    -2 /*throw new RuntimeException("invalid array without duplicate")*/
  }

  /**
    * @see http://blog.csdn.net/jsqfengbao/article/details/47438557
    */
  def findDuplicate(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1 || arr.min < 0 || arr.max > arr.length - 1) return -1

    for (i <- arr.indices) {
      while (i != arr(i)) { //要求做到`下标和数值相等`，否则交换
        if (arr(i) == arr(arr(i))) return arr(i) //所有数字都在`0到n-1`的范围内
        else {
          val temp = arr(i)
          arr(i) = arr(temp)
          arr(temp) = temp
        }
      }
    }
    -2
  }

  /**
    * @see http://blog.csdn.net/qunxingvip/article/details/51759278
    *      利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数+n，
    *      之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
    */
  def findDuplicate2(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1 || arr.min < 0 || arr.max > arr.length - 1) return -1

    val length = arr.length
    for (i <- arr.indices) {
      var temp = arr(i) //index -> temp -> value
      if (temp >= length) temp -= length
      if (arr(temp) >= length) return temp
      arr(temp) = arr(temp) + length
    }
    -2
  }

  def main(args: Array[String]): Unit = {
    assert(findDuplicateHash(Array(2, 1, 3, 1, 4)) == 1)
    assert(findDuplicateHash(Array(2, 4, 3, 1, 4)) == 4)
    assert(findDuplicateHash(Array(2, 4, 2, 1, 4)) == 2)
    assert(findDuplicateHash(Array(2, 1, 3, 5, 4)) == -1)
    assert(findDuplicateHash(Array(2, 1, 3, 0, 4)) == -2)

    assert(findDuplicate(Array(2, 1, 3, 1, 4)) == 1)
    assert(findDuplicate(Array(2, 4, 3, 1, 4)) == 4)
    assert(findDuplicate(Array(2, 4, 2, 1, 4)) == 2)
    assert(findDuplicate(Array(2, 1, 3, 5, 4)) == -1)
    assert(findDuplicate(Array(2, 1, 3, 0, 4)) == -2)

    assert(findDuplicate2(Array(2, 1, 3, 1, 4)) == 1)
    assert(findDuplicate2(Array(2, 4, 3, 1, 4)) == 4)
    assert(findDuplicate2(Array(2, 4, 2, 1, 4)) == 2)
    assert(findDuplicate2(Array(2, 1, 3, 5, 4)) == -1)
    assert(findDuplicate2(Array(2, 1, 3, 0, 4)) == -2)
  }

}
