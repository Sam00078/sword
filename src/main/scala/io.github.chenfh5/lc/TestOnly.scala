package io.github.chenfh5.lc

import scala.collection.mutable.ArrayBuffer

object TestOnly {

  def main(args: Array[String]): Unit = {
    val nums = ArrayBuffer(0, 1, 2, 2, 3, 0, 4, 2)
    println(nums)
    val numsNew = nums.filter(_ != 2)
    println(numsNew)
  }

}
