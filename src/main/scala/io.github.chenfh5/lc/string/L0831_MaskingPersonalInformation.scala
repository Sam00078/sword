package io.github.chenfh5.lc.string

object L0831_MaskingPersonalInformation {

  def maskPII(S: String): String = {
    // email
    val atPos = S.indexOf("@")
    var s = S
    if (atPos > 0) {
      s = s.toLowerCase
      return s.head + "*****" + s.substring(atPos - 1)
    }
    // phone
    val country = Array("", "+*-", "+**-", "+***-")
    s = S.replaceAll("[^0-9]", "")
    country(s.length - 10) + "***-***-" + s.substring(s.length - 4)
  }

  def main(args: Array[String]) {
    val input = "LeetCode@LeetCode.com"
    val res = maskPII(input)
    print(res)
  }

}
