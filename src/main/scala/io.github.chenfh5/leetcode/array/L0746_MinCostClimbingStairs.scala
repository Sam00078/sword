package io.github.chenfh5.leetcode.array

object L0746_MinCostClimbingStairs {

  // @see http://leetcode.com/problems/min-cost-climbing-stairs/solution/127696/Min-Cost-Climbing-Stairs/148590
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    cost match {
      case _ if cost == null => 0
      case _ if cost.length == 1 => cost.head
      case _ if cost.length >= 2 =>
        // Once you pay the cost, you can either climb one or two steps
        // dp(i) is the minimum cost to reach the ith stair
        // you can either start from the step with index 0, or the step with index 1, so the cost is zero
        var (dp0, dp1) = (math.min(0, 0) + cost(0), math.min(0, cost(0)) + cost(1)) // dp1 = min(dp-1, dp0) + cost1, since dp-1,dp-2 is free to arrival
        for (i <- 2 until cost.length) {
          val dp2 = math.min(dp0, dp1) + cost(i)
          dp0 = dp1 // forward replace
          dp1 = dp2
        }
        math.min(dp0, dp1)
    }
  }

  def main(args: Array[String]) {
    val cost = Array(10, 15)
    val res = minCostClimbingStairs(cost)
    print(res)
    assert(res == 10)
  }

}
