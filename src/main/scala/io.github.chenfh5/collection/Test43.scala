package io.github.chenfh5.collection

/**
  * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
  */
object Test43 {

  /**
    * @see https://www.jianshu.com/p/5fc41ff88c3a
    *      http://www.codingblog.cn/blog/55027.html
    *      https://my.oschina.net/u/2260265/blog/350473
    *      http://blog.csdn.net/jsqfengbao/article/details/47414139
    *
    *      新加入一个骰子，它出现1-6的概率是相等的，可以看成各出现一次，
    *      那么出现和为s的次数等于在加入之前出现和为s-1,s-2,s-3,s-4,s-5,s-6这6种情况的次数之和。
    *      如此循环，直到加入n个骰子结束。
    */
  //TODO
  def printProbability(diceNum: Int): Unit = {
    if (diceNum < 1) return
    val result = Array.ofDim[Int](2, 6 * diceNum + 1) //构建两个数组，分别存储前一次和后一次的和出现的`次数`


    for (i <- 1 to 6) result(1)(i) = 1 //初始化第一个数组（仅有一个骰子的情况）

    //第二个骰子到第n个骰子
    for (k <- 2 to diceNum) {
      //当骰子数为k，那么sum的范围为k到k*6
      for (i <- k to 6 * k) {
        for (j <- i - 6 until i) {
          //当前数字之和 = 前一次出现1的次数 + 前一次出现2的次数 + ... + 前一次出现6的次数
          if (j > 0) result(k % 2)(i) += result((k - 1) % 2)(j)
        }
      }
    }

    var sum = 0.0
    for (i <- diceNum to 6 * diceNum) {
      sum += result(diceNum % 2)(i)
    }
    println
    println("diceNum = " + diceNum)
    for (i <- diceNum to 6 * diceNum) {
      println("probability " + i + ": " + result(diceNum % 2)(i) / sum)
    }
  }

  def main(args: Array[String]): Unit = {
    printProbability(1)
    printProbability(0)
    printProbability(2)
    printProbability(5)
    printProbability(11)
  }

}
