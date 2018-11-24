package io.github.chenfh5.sword1st

/**
  * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 str为0或者字符串不是一个合法的数值则返回0
  */
object Test49 {

  /**
    * @see http://blog.csdn.net/ouyangyanlan/article/details/72897779
    */
  def str2Int(str: String): Int = {
    if (str == null || str.length < 1 || str.length > Long.MaxValue.toString.length - 1) throw new IllegalArgumentException("invalid int str")

    var res = 0L
    val head = str.head
    var pos = if (head == '-' || head == '+') 1 else 0

    while (pos < str.length) {
      val char = str(pos)
      if (char > '9' || char < '0') throw new IllegalArgumentException("invalid float str")
      res = (res << 1) + (res << 3) + (char - '0') //(res << 1) + (res << 3) 即 res*2+res*8=res*10 + (str(pos) - '0')即取i的个位值，也可以是 (str(pos) & 0x0f)
      pos += 1
    }

    res = if (head == '-') -res else res
    if (res > Int.MaxValue || res < Int.MinValue) throw new IllegalArgumentException("invalid int str") else res.toInt
  }

  def str2Double(str: String): Double = {
    // 11.1234
    // 11.000123
    // 11.000
    if (str == null || str.length < 1 || str.length > Long.MaxValue.toString.length - 1) throw new IllegalArgumentException("invalid float str")
    val part = str.split("\\.")
    // case 1
    if (part.length > 2) throw new IllegalArgumentException("invalid float str")
    // case 2
    if (part.length == 1) return str2Int(part.head) + 0d
    // case 3
    val (intPart, floatPart) = (part.head, part.last)
    val intRes = str2Int(intPart)
    val prefixZeroCnt = findPrefixZeroCnt(floatPart)
    if (prefixZeroCnt == floatPart.length) intRes + 0d
    else {
      val notZeroPart = str2Int(floatPart.substring(prefixZeroCnt))

      var (i, tmp) = (floatPart.length, notZeroPart.toDouble)
      while (i > 0) {
        tmp *= 0.1
        i -= 1
      }
      intRes + tmp
    }
  }

  def findPrefixZeroCnt(str: String) = {
    str.count(_ == "0")
  }

  def main(args: Array[String]): Unit = {
    println("Int.MaxValue = " + Int.MaxValue)
    println("Int.MinValue = " + Int.MinValue)
    println("Long.MinValue = " + Long.MinValue)
    println("Long.MinValue = " + Long.MinValue)

    assert(str2Int("1200354") == 1200354)
    assert(str2Int("+1200354") == 1200354)
    assert(str2Int("-1200354") == -1200354)
    assert(str2Int("+2147483647") == 2147483647)
    assert(str2Int("-2147483648") == -2147483648)
    assert(str2Int("+2147483649") == Exception)
    assert(str2Int("-2147483649") == 0)
    assert(str2Int("00") == 0)
    assert(str2Int("123ab345") == 0)

    // str2Double
    assert(str2Double("11.2231") == 11.2231d)
    assert(str2Double("11.0002231") == 11.0002231d)
    assert(str2Double("11.000") == 11.000d)
  }

}
