package io.github.chenfh5.collection

/**
  * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 str为0或者字符串不是一个合法的数值则返回0
  */
object Test49 {

  /**
    * @see http://blog.csdn.net/ouyangyanlan/article/details/72897779
    */
  def str2Int(str: String): Int = {
    if (str == null || str.length < 1 || str.length > Long.MaxValue.toString.length - 1) return 0

    var res = 0L
    val head = str.head
    var pos = if (head == '-' || head == '+') 1 else 0

    while (pos < str.length) {
      val char = str(pos)
      if (char > '9' || char < '0') return 0
      res = (res << 1) + (res << 3) + (char - '0') //(res << 1) + (res << 3) 即 res*2+res*8=res*10 + (str(pos) - '0')即取i的个位值，也可以是 (str(pos) & 0x0f)
      pos += 1
    }

    res = if (head == '-') -res else res
    if (res > Int.MaxValue || res < Int.MinValue) 0 else res.toInt
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
    assert(str2Int("+2147483649") == 0)
    assert(str2Int("-2147483649") == 0)
    assert(str2Int("00") == 0)
    assert(str2Int("123ab345") == 0)
  }

}
