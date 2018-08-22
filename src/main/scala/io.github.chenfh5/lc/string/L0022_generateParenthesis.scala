package io.github.chenfh5.lc.string

object L0022_generateParenthesis {


  import scala.collection.mutable.ListBuffer


  // 括号产生器
  // DP @see https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method./11044
  def generateParenthesis(n: Int): List[String] = {
    /*
    the result f(n) will be put an extra () pair to f(n-1) -> ()+f(n-1)
    f0=""
    f1=`(`+f0+`)`
    f2=`(`+f0+`)`f(1) + `(`+f(1)+`)`
     */

    // f(n) = `(` f(0) `)` f(n-1) + `(` f(1) `)` f(n-2) + ( f(2) ) f(n-3) + ...... + ( f(n-1) ) f(0)
    val dp = ListBuffer[List[String]]()
    dp.append(List(""))
    for (i <- 1 to n) {
      val curList = ListBuffer[String]()
      for (j <- 0 until i) // totally i count need to plus
        for (first <- dp(j)) // f0
          for (second <- dp(i - 1 - j)) // f(n-1)
            curList.append("(" + first + ")" + second) // update list
      dp.append(curList.toList)
    }
    dp.last
  }


  // Backtrack @see https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
  def generateParenthesis2(n: Int): List[String] = {
    val list = ListBuffer[String]()
    backtrack(list, "", 0, 0, n)
    list.toList
  }

  def backtrack(list: ListBuffer[String], s: String, open: Int, close: Int, n: Int): Unit = {
    if (s.length == n * 2) {
      // () is a pair, it means double len of n
      list.append(s)
      return
    }
    if (open < n) backtrack(list, s + "(", open + 1, close, n) // n=3, open=0,1,2,3(2+1) -> close=0,1,2,3(2+1)
    if (close < open) backtrack(list, s + ")", open, close + 1, n) // it must have open first, then the close
  }

  def main(args: Array[String]) {
    val res = generateParenthesis(3)
    print(res)
  }

}
