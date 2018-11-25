package io.github.chenfh5.leetcode.array

object L0121_MaxProfit {

  /**
    * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39039/Sharing-my-simple-and-clear-C++-solution
    */
  def maxProfit(prices: Array[Int]): Int = {
    if (prices == null || prices.length < 2) return 0

    var (maxProf, minPrice) = (0, Int.MaxValue)
    for (i <- 0 until prices.length) {
      minPrice = math.min(minPrice, prices(i)) // used min to cover the ahead calculated values
      maxProf = math.max(maxProf, prices(i) - minPrice)
    }
    maxProf
  }

  def main(args: Array[String]) {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val res = maxProfit(prices)
    println(res)
    assert(res == 5)
  }

}
