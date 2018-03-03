package io.github.chenfh5.other

import scala.collection.mutable.ListBuffer


object RestoreIp {

  /**
    * @see https://www.jianshu.com/p/9dc8f139a61d
    *      https://www.jianshu.com/p/6c560a96468a
    *      http://www.cnblogs.com/theskulls/p/5348755.html
    *      https://www.tianmaying.com/tutorial/LC93
    *      http://zhangll98.iteye.com/blog/1542006 //走不通就退回再走的技术为回溯法
    *      http://blog.csdn.net/lovesummerforever/article/details/18617403
    */
  //TODO
  def getIp(str: String): ListBuffer[String] = {
    val result = ListBuffer[String]()
    val list = ListBuffer[String]()

    if (str == null || str.length < 4 || str.length > 12) return result
    helper(result, list, str, 0)
    result
  }

  def isValid(str: String): Boolean = {
    if (str.head == '0') return str == "0"
    val digit = Integer.valueOf(str)
    digit >= 0 && digit <= 255
  }

  def helper(result: ListBuffer[String], list: ListBuffer[String], str: String, startPos: Int): Unit = {
    if (list.size == 4) {
      //满4段了
      if (startPos != str.length) return //未遍历到最后一个字符
      val sb = new StringBuilder()
      for (i <- list) {
        sb.append(i)
        sb.append(".")
      }
      sb.deleteCharAt(sb.length - 1)
      result += sb.toString()
      return
    }

    for (i <- startPos until str.length if i < startPos + 3) {
      val temp = str.substring(startPos, i + 1)
      if (isValid(temp)) {
        list += temp
        helper(result, list, str, i + 1) //回溯处理
        list.remove(list.size - 1) //还原
      }
    }
  }

  def main(args: Array[String]) {
    assert(getIp("25525511135") == ListBuffer("255.255.11.135", "255.255.111.35"))
  }

}
