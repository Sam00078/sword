package io.github.chenfh5.lc

object L0122_MaxProfit2 {

  /**
    * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/39402/Is-this-question-a-joke
    */
  def maxProfit(prices: Array[Int]): Int = {
    var totalProf = 0
    for (i <- 0 until prices.length - 1) {
      // once there is profit, buy it. Though the latter price may be more high, it can buy again, since there is no exchange fee
      if (prices(i + 1) > prices(i)) totalProf += prices(i + 1) - prices(i)
    }
    totalProf
  }

  def main(args: Array[String]) {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val res = maxProfit(prices)
    println(res)
    assert(res == 7)
  }

}
