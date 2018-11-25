package io.github.chenfh5.leetcode.twoPointers

object L0881_NumRescueBoats {

  // @see https://leetcode.com/problems/boats-to-save-people/discuss/156715/Simple-sort-and-two-pointer-with-detailed-provement
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    val sortPeople = people.sortWith(_ < _)
    var (l, r, boat) = (0, people.length - 1, 0)
    while (l <= r) {
      // always to match lightest and heaviest
      if (sortPeople(l) + sortPeople(r) <= limit) {
        // Each boat carries at most 2 people at the same time
        l += 1
        r -= 1
      } else r -= 1 // headiest pop with one boat alone
      boat += 1
    }
    boat
  }

  def main(args: Array[String]) {
    val people = Array(1, 2, 3, 2)
    val res = numRescueBoats(people, 3)
    print(res)
    assert(res == 3)
  }

}
