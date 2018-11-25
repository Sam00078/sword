package io.github.chenfh5.leetcode.string

object L0537_ComplexNumberMultiply {

  // @see https://leetcode.com/problems/complex-number-multiplication/discuss/100431/Java-(a1+b1)*(a2+b2)-(a1a2-+-b1b2-+-(a1b2+b1a2))
  def complexNumberMultiply(a: String, b: String): String = {
    // (a1+b1i)(a2+b2i)=a1a2-b1b2+a1b2i+a2b1i
    val (aStr, bStr) = (a.split("\\+"), b.split("\\+"))
    val (a1, b1) = (aStr.head.toInt, aStr.last.dropRight(1).toInt)
    val (a2, b2) = (bStr.head.toInt, bStr.last.dropRight(1).toInt)

    val a1a2 = a1 * a2
    val b1b2 = b1 * b2

    val a1b2 = a1 * b2
    val a2b1 = a2 * b1

    val realPart = a1a2 - b1b2
    val virtualPart = a1b2 + a2b1

    s"$realPart+${virtualPart}i"
  }

  def main(args: Array[String]) {
    val (a, b) = ("1+-1i", "1+-1i")
    val res = complexNumberMultiply(a, b)
    print(res)
    assert(res == "0+-2i")
  }

}
