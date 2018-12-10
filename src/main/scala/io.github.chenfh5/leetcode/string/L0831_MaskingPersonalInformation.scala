package io.github.chenfh5.leetcode.string

object L0831_MaskingPersonalInformation {

  def maskPII(S: String): String = {
    // email
    val atPos = S.indexOf("@")
    if (atPos > 0) {
      val s = S.toLowerCase
      return s.head + "*****" + s.substring(atPos - 1)
    }
    // phone
    val country = Array("", "+*-", "+**-", "+***-")
    val s = S.replaceAll("[^0-9]", "")
    country(s.length - 10) + "***-***-" + s.substring(s.length - 4)
  }

  def main(args: Array[String]) {
    val input = "LeetCode@LeetCode.com"
    val res = maskPII(input)
    println(res)
    assert(res == "l*****e@leetcode.com")

    val input2 = "13800138000"
    val res2 = maskPII(input2)
    println(res2)
    assert(res2 == "+*-***-***-8000")
  }

}
