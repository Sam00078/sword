package io.github.chenfh5.sword1st

/**
  * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
  */
object Test04 {

  def replace(srcStr: String): String = {
    if (srcStr == null) return "nullStr"
    srcStr.replace(" ", "%20")
  }

  def main(args: Array[String]) {
    assert(replace(null) == "nullStr")
    assert(replace("We are happy.") == "We%20are%20happy.")
  }

}
