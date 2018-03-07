package io.github.chenfh5.collection

/**
  * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
  * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
  */
object Test28 {

  /**
    * @see http://blog.csdn.net/bitcarmanlee/article/details/51558272
    *      http://blog.csdn.net/xiazdong/article/details/7986015
    *      http://www.ayqy.net/blog/%E5%85%A8%E6%8E%92%E5%88%97%E7%AE%97%E6%B3%95%E5%88%86%E6%9E%90%EF%BC%88%E5%8E%9F%E5%88%9B%E6%96%B9%E6%B3%95%E4%B8%80%E8%88%AC%E6%96%B9%E6%B3%95%E5%AD%97%E5%85%B8%E5%BA%8F%E6%B3%95%EF%BC%89/
    *      定义一个全局数组，把100个数放进去，然后写一个迭代函数，从数组里依次取一个数出来然后进入下一个迭代并继续从剩下的数里取一个出来，直到数组里的数被取空，输出结果；然后回到上一层迭代继续取没有取过的数。
    *
    */
  def permutation(arr: Array[Char], beginIndex: Int, endIndex: Int): Unit = {
    if (arr == null || arr.length < 1) throw new RuntimeException("invalid input size")

    if (beginIndex == endIndex) print(new String(arr) + " ")
    else {
      for (i <- beginIndex to endIndex) {
        swap(arr, i, beginIndex) //交换前缀，使其产生下一个前缀
        permutation(arr, beginIndex + 1, endIndex) //先a,再b，再c，然后回退到b，bc交换，再回退到a，ab交换，
        swap(arr, beginIndex, i) //将前缀换回，继续做上一个前缀的排列
      }
    }
  }

  def swap(s: Array[Char], i: Int, j: Int): Unit = {
    if (i != j) {
      val tmp = s(i)
      s(i) = s(j)
      s(j) = tmp
    }
  }

  def main(args: Array[String]): Unit = {
    val input = Array('a', 'b', 'c')
    permutation(input, 0, input.length - 1) //abc acb bac bca cba cab

    println()
    val input2 = Array('a', 'b', 'c', 'd')
    permutation(input2, 0, input2.length - 1) //abcd abdc acbd acdb adcb adbc bacd badc bcad bcda bdca bdac cbad cbda cabd cadb cdab cdba dbca dbac dcba dcab dacb dabc
  }

}
