package io.github.chenfh5.leetcode.array

object L0605_CanPlaceFlowers {

  /**
    * @see https://leetcode.com/problems/can-place-flowers/discuss/103898/Java-Greedy-solution-O(flowerbed)-beats-100
    */
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var count = 0
    for (i <- 0 until flowerbed.length if count < n) {
      if (flowerbed(i) == 0) {
        // flowerbed(i) == 0 is need
        val prev = if (i == 0) 0 else flowerbed(i - 1)
        val next = if (i == flowerbed.length - 1) 0 else flowerbed(i + 1)
        if (prev == 0 && next == 0) {
          flowerbed(i) = 1
          count += 1
        }
      }
    }
    count == n
  }

  def main(args: Array[String]) {
    val flowerbed = Array(1, 0, 0, 0, 1)
    val res = canPlaceFlowers(flowerbed, 2)
    println(res)
    assert(!res)
  }

}
