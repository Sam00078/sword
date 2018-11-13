package io.github.chenfh5.lc.string


object L0929_UniqueEmailAddresses {

  def numUniqueEmails(emails: Array[String]): Int = {
    emails.map(parse(_)).toSet.size
  }

  def parse(email: String): String = {
    val parts = email.split("@")
    val local = parts.head.split("\\+") // drop after `+`
    val domain = parts.last
    local.head.replace(".", "") + "@" + domain
  }

  def main(args: Array[String]) {
    val input = Array("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com")
    val res = numUniqueEmails(input)
    println(res)
    assert(res == 2)
  }

}
