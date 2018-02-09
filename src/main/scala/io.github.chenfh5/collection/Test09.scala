package io.github.chenfh5.collection

/**
  * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项
  * f(n) = f(n-1) + f(n-2)
  */
object Test09 {

  def getFibonacci(n: Int): Int = {
    if (n <= 0) return 0
    if (n == 1 || n == 2) return 1

    var prePre = 1 //f(1)
    var pre = 1 //f(2)
    var current = 2 //f(3)

    for (i <- 3 to n) {
      current = pre + prePre
      /*n往n+1滚，记录下来，不用每次重算之前的，备忘录算法*/
      prePre = pre
      pre = current
    }
    current
  }

  def main(args: Array[String]): Unit = {
    assert(getFibonacci(-11) == 0)
    assert(getFibonacci(0) == 0)
    assert(getFibonacci(1) == 1)
    assert(getFibonacci(2) == 1)
    assert(getFibonacci(4) == 3)
    assert(getFibonacci(8) == 21)
    assert(getFibonacci(13) == 233)
  }

}
