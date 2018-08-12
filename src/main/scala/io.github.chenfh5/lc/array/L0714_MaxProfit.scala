package io.github.chenfh5.lc.array

object L0714_MaxProfit {

  // @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108892/Java-DP-solution-O(n)-to-O(1)-space
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    prices match {
      case _ if prices == null || prices.length <= 1 => 0
      case _ =>
        var (hold, notHold) = (0 - prices.head, 0)
        // hold[i] : The maximum profit of holding stock until day i
        // notHold[i] : The maximum profit of not hold stock until day i
        for (i <- 1 until prices.length) {
          hold = math.max(hold, notHold - prices(i)) // buy stock or not, if buy profit would minus price
          notHold = math.max(notHold, hold + prices(i) - fee) // sell stock or not, if sell profit hot + price - fee
        }
        notHold
    }
  }

  def main(args: Array[String]) {
    val nums = Array(1, 3, 2, 8, 4, 9)
    val res = maxProfit(nums, 2)
    print(res)
    assert(res == 8)
  }

}
