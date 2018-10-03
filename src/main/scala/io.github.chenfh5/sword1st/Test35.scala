package io.github.chenfh5.sword1st

import scala.collection.mutable


/**
  * 题目：在字符串中找出第一个只出现一次的字符。
  */

object Test35 {

  /**
    * @see http://blog.csdn.net/jsqfengbao/article/details/47376859
    *      http://wiki.jikexueyuan.com/project/for-offer/question-thirty-five.html
    */
  def firstNotRepeatingChar(str: String): Char = {
    if (str == null) throw new IllegalArgumentException("invalid input")

    val hash = mutable.HashMap[Char, Int]()
    val charArr = str.toCharArray

    //第一次扫描字符串时，每扫描到一个字符就在哈希表中的对应项中把次数加1
    for (i <- charArr) {
      if (hash.contains(i)) hash.put(i, hash.get(i).head + 1)
      else hash.put(i, 1)
    }

    //第二次扫描时，每扫描到一个字符就能从哈希表中得到该字符出现的次数，找到第一次value为1的key
    for (i <- charArr) {
      if (hash.get(i).head == 1) return i
    }
    //    throw new RuntimeException("without not repeating char")
    '\0'
  }

  def main(args: Array[String]): Unit = {
    assert(firstNotRepeatingChar("google") == 'l')
    assert(firstNotRepeatingChar("aabccdbd") == '\0')
    assert(firstNotRepeatingChar("abcdefg") == 'a')
    assert(firstNotRepeatingChar("gfedcba") == 'g')
    assert(firstNotRepeatingChar("zgfedcba") == 'z')
  }

}
