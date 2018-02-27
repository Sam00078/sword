package io.github.chenfh5.collection

/**
  * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
  * 1. 求丑数(判断一个整数是否是丑数)
  * 2. 求从小到大的顺序的第1500个丑数
  */

object Test34 {

  /**
    * @see http://blog.csdn.net/github_2011/article/details/78127949
    */
  def isUglyNum(targetNum: Int): Boolean = {
    var varTargetNum = targetNum
    while (varTargetNum % 2 == 0) varTargetNum /= 2
    while (varTargetNum % 3 == 0) varTargetNum /= 3
    while (varTargetNum % 5 == 0) varTargetNum /= 5

    varTargetNum == 1
  }

  //暴力枚举
  def getUglyNumberExh(pos: Int): Int = {
    if (pos < 1) throw new IllegalArgumentException("invalid input")

    var targetNum = 0
    var uglyFound = 0
    while (uglyFound < pos) {
      targetNum += 1
      if (isUglyNum(targetNum)) uglyFound += 1
    }
    targetNum
  }

  private def minInThree(a: Int, b: Int, c: Int): Int = {
    val min = if (a < b) a else b
    if (min < c) min else c
  }

  /**
    * @see http://blog.csdn.net/double2hao/article/details/53640824
    */
  def getUglyNumber(pos: Int): Int = {
    if (pos < 1) throw new IllegalArgumentException("invalid input")

    val uglyArray = new Array[Int](pos) //http://www.runoob.com/scala/scala-arrays.html
    uglyArray(0) = 1
    var t2, t3, t5 = 0 //用T来记录M的下标

    for (i <- 1 until pos) {
      val M = uglyArray(i - 1) //当前ugly的最大值
      while (uglyArray(t2) * 2 <= M) t2 += 1 //M2(t2-1) <= M
      while (uglyArray(t3) * 3 <= M) t3 += 1 //M3(t3-1) <= M
      while (uglyArray(t5) * 5 <= M) t5 += 1 //M5(t5-1) <= M

      val minInThisLoop = minInThree(uglyArray(t2) * 2, uglyArray(t3) * 3, uglyArray(t5) * 5) //M = min(M2, M3, M5)
      uglyArray(i) = minInThisLoop
    }
    uglyArray(pos - 1)
  }

  /**
    * @see scala tag description
    *      https://docs.scala-lang.org/overviews/scaladoc/for-library-authors.html
    */
  def main(args: Array[String]): Unit = {
    assert(isUglyNum(1))
    assert(isUglyNum(8))
    assert(!isUglyNum(35))
    assert(isUglyNum(859963392))

    //    assert(getUglyNumberExh(1500) == 859963392)
    assert(getUglyNumber(1500) == 859963392)

  }

}
