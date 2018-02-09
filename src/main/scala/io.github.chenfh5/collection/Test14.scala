package io.github.chenfh5.collection

/**
  * 调整数组顺序使奇数位于偶数前面
  * 这里前面指的是左边，所以将最右边的奇数odd与最左边的even交换即可，一趟下来O(n)
  */
object Test14 {

  def orderInOddEven(arr: Array[Int]): Array[Int] = {

    if (arr == null | arr.length < 2) return arr

    var start = 0
    var end = arr.length - 1

    while (start < end) {
      while (start < end && condition(arr(start))) start = start + 1 //找到第一个偶数的位置
      while (start < end && !condition(arr(end))) end = end - 1 //找到最后一个奇数的位置

      //swap
      val tmp = arr(start)
      arr(start) = arr(end)
      arr(end) = tmp
    }
    arr
  }

  def condition(number: Int): Boolean = {
    number % 2 == 1 //奇数在左
    //    number < 0 //负数在左
  }

  def main(args: Array[String]): Unit = {
    //奇数
    println(orderInOddEven(Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).toSeq)
    println(orderInOddEven(Array(6, 4, 2, 3, 5, 1, 9)).toSeq)
    println(orderInOddEven(Array(1, 9, 6, 3, 4, 5)).toSeq)

    //负数
    println(orderInOddEven(Array(6, -4, -2, 3, -5, 1, -9)).toSeq)
    println(orderInOddEven(Array(-1, 9, 6, -3, 4, 5)).toSeq)
  }

}
