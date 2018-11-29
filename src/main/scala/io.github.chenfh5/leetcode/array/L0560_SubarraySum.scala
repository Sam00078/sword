package io.github.chenfh5.leetcode.array

object L0560_SubarraySum {

  // @see https://leetcode.com/problems/subarray-sum-equals-k/discuss/134689/Three-Approaches-With-Explanation
  def subarraySum(nums: Array[Int], k: Int): Int = {
    var (count, sum) = (0, 0)
    val preSumFreq = scala.collection.mutable.Map[Int, Int]()
    preSumFreq.put(sum, 1) // initial (sum, freq)
    for (num <- nums) {
      sum += num // 用sum来记录到`当前`位置的累加和, `当前`已经限定了位置是当下的pos
      /**
        * 遍历数组，累加到每一个元素的sum添加到map中，得到0, sum0，sum1，sum2, …., sum(n-1).如果sum(j) - sum(i) = k，即可得sum(i+1…j)为k，即计数+1
        * https://blog.csdn.net/rxt2012kc/article/details/73716288
        */
      if (preSumFreq.contains(sum - k)) count += preSumFreq(sum - k)

      if (preSumFreq.contains(sum)) preSumFreq.put(sum, preSumFreq(sum) + 1)
      else preSumFreq.put(sum, 1)
    }
    count
  }

  def main(args: Array[String]) {
    val nums = Array(1, 1, 1)
    val res = subarraySum(nums, 2)
    println(res)
    assert(res == 2)
  }

}
