package io.github.chenfh5.lc.array

object L0825_NumFriendRequests {

  // @see https://leetcode.com/problems/friends-of-appropriate-ages/discuss/127341/10ms-concise-Java-solution-O(n)-time-and-O(1)-space/135624
  def numFriendRequests(ages: Array[Int]): Int = {
    // B is in range (0.5*A+7, A], (inverse NOT friend => friend)
    val (ageCnt, ageSum) = (new Array[Int](121), new Array[Int](121)) // 1 <= ages[i] <= 120
    for (age <- ages) ageCnt(age) += 1

    var (ageCurSum, res) = (0, 0)
    // 0.5 * a + 7 < b <= a，-> 0.5 * a > 7, -> a > 14，-> so a starts from 15
    for (i <- 15 until 121) {
      ageCurSum += ageCnt(i)
      ageSum(i) = ageCurSum

      if (ageCnt(i) > 0) {
        // ageA * 0.5 + 7 < ageB && ageA >= ageB && (ageA >= 100 || 100 >= ageB)
        val ageCnt2 = ageSum(i) - ageSum(i / 2 + 7) // age between[i/2+7 ~ i]should be include, since i >= i/2+7 -> i>=14, so cnt would not be lt 1
        res += (ageCnt(i) * (ageCnt2 - 1)) // minus himself
      }
    }
    res
  }

  // double loop, O(n^2)
  // @see https://leetcode.com/submissions/detail/168960495/
  def numFriendRequests2(ages: Array[Int]): Int = {
    val count = new Array[Int](121)
    for (age <- ages) count(age) += 1

    var ans = 0

    for (ageA <- 0 to 120) {
      val countA = count(ageA)
      for (ageB <- 0 to 120) {
        val countB = count(ageB)
        if (ageA * 0.5 + 7 < ageB && ageA >= ageB && (ageA >= 100 || 100 >= ageB)) {
          ans += countA * countB
          if (ageA == ageB) ans -= countA // ans=ans+a*b-a=ans+(b-1)a, i.e., minus himself
        }
      }
    }
    ans
  }

  def main(args: Array[String]) {
    val ages = Array(20, 110, 120, 100, 30)
    val res = numFriendRequests(ages)
    print(res)
    assert(res == 3)
  }

}
