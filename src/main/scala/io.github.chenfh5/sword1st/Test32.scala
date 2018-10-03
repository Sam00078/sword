package io.github.chenfh5.sword1st

/**
  * 输入一个整数n求从1到n这n个整数的十进制表示中1出现的次数
  */
object Test32 {

  /**
    * 累加1到n中每个整数1出现的次数。
    * 我们可以每次通过对10求余数判断整数的个位数字是不是1，
    * 如果这个数字大于10，除以10之后再判断个位数字是不是1。
    * 暴力枚举。
    *
    * @see https://www.coder4.com/archives/3366
    */
  def numberOf1Between1AndNExh(n: Int): Int = {
    if (n < 1) throw new IllegalArgumentException("invalid input n")

    var count = 0

    for (i <- 1 to n) {
      var varI = i
      while (varI > 0) {
        if (varI % 10 == 1) count += 1
        varI /= 10 //double.toInt
      }
    }
    count
  }

  /**
    * @see http://blog.csdn.net/yi_afly/article/details/52012593
    *      http://blog.csdn.net/ns_code/article/details/27563485
    *      将n的各个位分为两类：个位与其它位。
    *      找1出现的规律。
    *
    *      534 = （个位1出现次数）+（十位1出现次数）+（百位1出现次数）=（53*1+1）+（5*10+10）+（0*100+100）= 214
    *      504 = （50*1+1）+（5*10）+（0*100+100） = 201
    */
  def numberOf1Between1AndNReg(n: Int): Int = {
    if (n < 1) throw new IllegalArgumentException("invalid input n")

    var count = 0 //1出现的个数
    var cur = 1 //n的每一位的值记为weight
    var base = 1 //weight位所在的十进制基
    var remain = n //weigh的其余高位

    while (remain > 0) {
      cur = remain % 10 //先取低位(百十个)
      remain /= 10 //再取其余高位

      count += remain * base

      if (cur == 1) count += n % base + 1
      else if (cur > 1) count += base
      base *= 10
    }
    count
  }

  def main(args: Array[String]): Unit = {
    assert(numberOf1Between1AndNExh(534) == 214)
    assert(numberOf1Between1AndNExh(531) == 214)
    assert(numberOf1Between1AndNExh(530) == 213)
    assert(numberOf1Between1AndNExh(504) == 201)
    assert(numberOf1Between1AndNExh(514) == 207)
    assert(numberOf1Between1AndNExh(10) == 2)

    assert(numberOf1Between1AndNReg(534) == 214)
    assert(numberOf1Between1AndNReg(531) == 214)
    assert(numberOf1Between1AndNReg(530) == 213)
    assert(numberOf1Between1AndNReg(504) == 201)
    assert(numberOf1Between1AndNReg(514) == 207)
    assert(numberOf1Between1AndNReg(10) == 2)
  }

}
