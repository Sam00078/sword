package io.github.chenfh5.leetcode.array

object L0287_FindDuplicate {

  /**
    * @see https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation):-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
    *      binary search
    */
  def findDuplicate(nums: Array[Int]): Int = {
    nums match {
      case _ if nums == null || nums.length < 2 => 1
      case _ =>
        var (low, high) = (1, nums.length - 1)
        while (low < high) {
          val mid = (low + high) / 2
          var count = 0

          // input is 1~N, only one duplicate
          for (num <- nums) {
            if (num <= mid) count += 1 // count is the count gt mid
          }

          // count more than the mid, means duplicate
          if (count <= mid) low = mid + 1
          else high = mid
        }
        low
    }
  }

  def main(args: Array[String]) {
    val nums = Array(3, 1, 3, 4, 2)
    val res = findDuplicate(nums)
    println(res)
    assert(res == 3)
  }

}
