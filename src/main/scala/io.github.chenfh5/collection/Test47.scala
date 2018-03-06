package io.github.chenfh5.collection

/**
  * 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
  */
object Test47 {

  /**
    * @see http://blog.csdn.net/gatieme/article/details/51493414
    *
    *      http://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
    *      <<      :     左移运算符，num << 1,相当于num乘以2
    *      >>      :     右移运算符，num >> 1,相当于num除以2
    *      >>>     :     无符号右移，忽略符号位，空位都以0补齐
    */
  def add(x: Int, y: Int): Int = {
    var (a, b) = (x, y)
    var sum = a ^ b //异或, 相同则0, 不同则1
    var carry = a & b //与, 有0则0, 全1则1(两个位都为1时，结果才为1)
    while (carry != 0) { //是否还有进位
      a = sum
      b = carry << 1 //carry乘以2

      sum = a ^ b
      carry = a & b
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    assert(add(17, 5) == 22)
    assert(add(17, 50) == 67)
    assert(add(197, 105) == 302)
  }

}
