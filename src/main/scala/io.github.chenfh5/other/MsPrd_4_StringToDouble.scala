package io.github.chenfh5.other

object MsPrd_4_StringToDouble {

  /**
    * @see http://www.voidcn.com/article/p-ejvoxfde-dm.html
    */
  def str2Double(str: String): Double = {
    if (str == null || str.length < 1 || str.indexOf('.') != str.lastIndexOf('.') || str.length > Double.MaxValue.toString.length - 1) throw new IllegalArgumentException("invalid input string")

    var (resBeforePoint, resAfterPoint) = (0d, 0d)
    val head = str.head
    var pos = if (head == '-' || head == '+' || head == '.') 1 else 0
    var isDecimalPoint = false
    var deCount = 0

    while (pos < str.length) {
      val char = str(pos)
      if (char == '.') isDecimalPoint = true
      else {
        if (char < '0' && char > '9') throw new IllegalArgumentException("invalid input string")
        if (!isDecimalPoint) resBeforePoint = resBeforePoint * 10 + char - '0'
        else {
          resAfterPoint = resAfterPoint * 10 + (char - '0')
          deCount += 1
        }
      }
      pos += 1
    }
    val res = resBeforePoint + resAfterPoint / math.pow(10, deCount)
    if (head == '-') -res
    else if (head == '.') res / math.pow(10, str.length - 1)
    else res
  }

  def main(args: Array[String]): Unit = {
    assert(str2Double("12") == 12d)
    assert(str2Double("+12") == 12d)
    assert(str2Double("-12") == -12d)

    assert(str2Double("12.3456") == 12.3456)
    assert(str2Double("-12.3456") == -12.3456)
    assert(str2Double("+12.3456") == 12.3456)

    assert(str2Double("0.73492657349265") == 0.73492657349265)
    assert(str2Double(".73492657349265") == 0.73492657349265)
    assert(str2Double("0.1007347349265") == 0.1007347349265)
    assert(str2Double(".1007347349265") == 0.1007347349265)
  }

}
