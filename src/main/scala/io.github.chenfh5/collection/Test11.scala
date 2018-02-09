package io.github.chenfh5.collection

/**
  * 实现函数double Power
  * 不得使用库函数，同时不需要考虑大数问题
  */
object Test11 {

  def power(base: Double, exponent: Int): Double = {
    if (base == 0 && exponent == 0) throw new RuntimeException("invalid number for both")
    if (exponent == 0) return 1

    var result: Double = 1.0
    for (i <- 0 until math.abs(exponent)) {
      result = result * base
    }
    if (exponent >= 0) result else 1 / result
  }

  def main(args: Array[String]): Unit = {
    assert(power(-2, -4) == math.pow(-2, -4))
    assert(power(2, 4) == math.pow(2, 4))
    assert(power(3, 6) == math.pow(3, 6))
    assert(power(5, 7) == math.pow(5, 7))

    println(power(10.1, 9).toString)
    println(math.pow(10.1, 9).toString)
    assert((power(10.1, 9) - math.pow(10.1, 9)) < 10E-6)
  }

}
