package io.github.chenfh5.collection

/**
  * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999
  * 当输入的n很大时，求最大的n位数用整型或长整型都会溢出。这里需要考虑大数问题。
  */
object Test12 {

  //将问题转换成数字排列
  //n位，每位都是0~9，将以0开头的排除掉
  def printMaxDigits(number: Int): Unit = {

    if (number <= 0) throw new RuntimeException("invalid number")

    var arr = new Array[Char](number)
    for (i <- 0 until 10) { //0~9
      arr(0) = ('0' + i).asInstanceOf[Char] //index=0
      printMaxDigitsRec(arr, number, 0)
    }
  }

  private def printNum(arr: Array[Char]): Unit = {
    var index = 0
    while (index < arr.length && arr(index) == '0') index = index + 1

    for (i <- index until arr.length) {
      print(arr(i))
    }
  }

  private def printMaxDigitsRec(arr: Array[Char], number: Int, index: Int): Unit = {
    if (number == index + 1) { //刚好全排列充满整个arr
      printNum(arr) //打印满载arr的首个非零char
      print("、")
    } else {
      for (i <- 0 until 10) { //数组逐位0~9全排列
        arr(index + 1) = ('0' + i).asInstanceOf[Char]
        printMaxDigitsRec(arr, number, index + 1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(('0' + 0).asInstanceOf[Char])
    println(('0' + 1).asInstanceOf[Char])
    println(('0' + 2).asInstanceOf[Char])
    println(('0' + 10).asInstanceOf[Char])
    println(('0' + 9).asInstanceOf[Char])

    printMaxDigits(3)
  }

}
