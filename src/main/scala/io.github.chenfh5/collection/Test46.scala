package io.github.chenfh5.collection

/**
  * 求 1+2+...+n,
  * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字以及条件判断语句 (A?B:C)。
  */
object Test46 {

  /**
    * @see http://z466459262.iteye.com/blog/1119184
    *      http://blog.csdn.net/loyopp/article/details/44086497
    */
  def initial(n: Int): Int = {
    if (n < 1) throw new IllegalArgumentException("invalid input n")
    var sum = 0
    isSum(n)

    def isSum(n: Int): Boolean = { //recursion
      sum += n
      //      (n - 1 <= 0) || isSum(n - 1) //A || B 为如果前面为真就只执行前面的，否则需要执行后面的
      (n > 0) && isSum(n - 1) //A && B 同时为真才能过
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    assert(initial(10) == 55)
    assert(initial(100) == 5050)
    assert(initial(1000) == 500500)
  }

}
