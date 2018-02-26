package io.github.chenfh5.collection

/**
  * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
  * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
  */
object Test28 {


  /**
    * @see http://blog.csdn.net/bitcarmanlee/article/details/51558272
    */
  def permutation(arr: Array[Char], beginIndex: Int, endIndex: Int): Unit = {
    if (arr == null || arr.length < 1) throw new RuntimeException("invalid input size")

    if (beginIndex == endIndex) print(new String(arr) + " ")
    else {
      for (i <- beginIndex to endIndex) {
        swap(arr, i, beginIndex) //交换前缀，使其产生下一个前缀
        permutation(arr, beginIndex + 1, endIndex)
        swap(arr, beginIndex, i) //将前缀换回，继续做上一个前缀的排列
      }
    }
  }

  def swap(s: Array[Char], i: Int, j: Int): Unit = {
    val tmp = s(i)
    s(i) = s(j)
    s(j) = tmp
  }

  def main(args: Array[String]): Unit = {
    val input = Array('a', 'b', 'c')
    permutation(input, 0, input.length - 1) //abc acb bac bca cba cab

    println()
    val input2 = Array('a', 'b', 'c', 'd')
    permutation(input2, 0, input2.length - 1) //abcd abdc acbd acdb adcb adbc bacd badc bcad bcda bdca bdac cbad cbda cabd cadb cdab cdba dbca dbac dcba dcab dacb dabc
  }

}
