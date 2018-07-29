package io.github.chenfh5.sword1st

import scala.collection.mutable


/**
  * 第一版：不能被继承的类，是单例/final
  * 第二版：输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
  * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
  */
object Test48 {

  /**
    * @see http://www.lpnote.com/2017/09/08/leetcode-3-longest-substring-without-repeating-characters/
    *      http://blog.csdn.net/liyuming0000/article/details/46925509
    */
  def lengthOfLongestSubstring(str: String): Int = {
    if (str == null) throw new IllegalArgumentException("invalid input str")

    val map = mutable.HashMap[Char, Int]() //current index of char in str

    var left, res = 0 //滑动窗口内的字符将不会重复，滑动窗口利用两个索引left,right分别指向窗口的前后界限cur
    for (right <- 0 until str.length) {
      val char = str(right)
      if (map.contains(char)) left = math.max(left, map.get(char).head) //retarget left pos
      res = math.max(res, right - left + 1) //res vs. cur
      map.put(char, right + 1)
    }
    res
  }

  def main(args: Array[String]): Unit = {
    assert(lengthOfLongestSubstring("arabcacfr") == 4) //acfr
    assert(lengthOfLongestSubstring("pwwkew") == 3) //wke
    assert(lengthOfLongestSubstring("abcabcbb") == 3) //abc
    assert(lengthOfLongestSubstring("bbbbb") == 1) //b
  }

}
