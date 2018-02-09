package io.github.chenfh5.collection

/**
  * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
  * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
  */
object Test10 {

  def getBitOfOne(n: Int): Int = {
    var cnt: Int = 0
    var tmp: Int = n
    while (tmp != 0) {
      cnt += 1
      tmp = (tmp - 1) & tmp
    }
    cnt
  }

  def main(args: Array[String]): Unit = {
    assert(getBitOfOne(8) == 1)
    assert(getBitOfOne(9) == 2)
    assert(getBitOfOne(7) == 3)
    assert(getBitOfOne(15) == 4)
  }

}
