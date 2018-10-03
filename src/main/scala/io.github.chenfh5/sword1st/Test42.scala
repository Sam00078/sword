package io.github.chenfh5.sword1st

/**
  * 翻转单词顺序 vs 左旋转字符串
  *
  * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。为简单起见，标点符号和普通字母一样处理。
  * 例如输入字符串"I am a student."，则输出"student. a am I"。
  *
  * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
  * 比如输入字符串"abcefg"和数字2，该函数将返回左旋转2位得到的结"cdefab"。
  */
object Test42 {

  def reverseSentence(sentence: String): String = {
    if (sentence == null) throw new IllegalArgumentException("invalid input string")
    val arr = sentence.split(" ")

    var start = 0
    var end = arr.length - 1
    while (start < end) {
      val temp = arr(start)
      arr(start) = arr(end)
      arr(end) = temp
      start += 1
      end -= 1
    }
    arr.mkString(" ")
  }

  def leftRotateString(str: String, nPos: Int): String = {
    if (str == null) throw new IllegalArgumentException("invalid input string")
    val rotate = str.take(nPos)
    val remain = str.drop(nPos)
    remain + rotate
  }

  def main(args: Array[String]): Unit = {
    assert(reverseSentence("I am a student.") == "student. a am I")
    assert(reverseSentence("Wonderful") == "Wonderful")
    assert(reverseSentence("wake me up") == "up me wake")

    assert(leftRotateString("abcdefg", 2) == "cdefgab")
    assert(leftRotateString("abcdefg", 1) == "bcdefga")
    assert(leftRotateString("abcdefg", 6) == "gabcdef")
    assert(leftRotateString("abcdefg", 7) == "abcdefg")
    assert(leftRotateString("abcdefg", 0) == "abcdefg")
  }

}
