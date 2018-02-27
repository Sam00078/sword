package io.github.chenfh5.collection

import scala.collection.mutable.ListBuffer

import org.slf4j.{Logger, LoggerFactory}


/**
  * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
  */
object Test33 {
  private val LOG = LoggerFactory.getLogger(getClass)

  /**
    * @see http://kubicode.me/2015/07/20/Algorithm/Minimum-Combination-in-Array/
    */
  def minCombination(arr: Array[Int]): String = {

    val arrSort = arr.sortWith {
      case (a, b) => //不是直接比较a与b，而是比较字符串拼接之后的ab与ba
        if ((a + "" + b) > (b + "" + a)) false else true
    }

    LOG.info("this is the     arr = {}", arr)
    LOG.info("this is the arrSort = {}", arrSort)

    val result = new StringBuilder
    for (i <- arrSort) {
      result.append(i)
    }
    result.toString()
  }

  def main(args: Array[String]): Unit = {
    assert(minCombination(Array(32, 321, 23)) == "2332132")
    assert(minCombination(Array(3, 5, 11, 14, 2)) == "1114235")
  }

}
