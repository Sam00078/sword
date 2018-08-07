package io.github.chenfh5.lc.array

object L0268_MissingNumber {

  /**
    * @see https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
    */
  def missingNumber(nums: Array[Int]): Int = {
    var res = nums.length // input is 0~N, then res=N, since for-loop without N, only N-1 is the max
    for (i <- 0 until nums.length) {
      res = res ^ i ^ nums(i) // a^b^b = a
    }
    res
  }

  /**
    * @see https://leetcode.com/submissions/detail/167933109/
    */
  def missingNumber2(nums: Array[Int]): Int = {
    val len = nums.length
    (len * (len + 1)) / 2 - nums.sum // 1+2+..+10 = (1+10)*(10/2) pairs = (11*10)/2 = (len+1)*len/2
  }

  def main(args: Array[String]) {
    val nums = Array(9, 6, 4, 2, 3, 5, 7, 0, 1)
    val res = missingNumber(nums)
    println(res)
    assert(res == 8)
  }

}
