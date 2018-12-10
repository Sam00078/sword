package io.github.chenfh5.leetcode.twoPointers


object L0632_SmallestRange {

  // @see http://leetcode.com/problems/smallest-range/discuss/104893/Java-Code-using-PriorityQueue.-similar-to-merge-k-array/151556
  def smallestRange(nums: List[List[Int]]): Array[Int] = {
    val arrOrd = new Ordering[Array[Int]] {
      def compare(a: Array[Int], b: Array[Int]) = b.head compare a.head
    }

    // Maintain a queue that have exact one element from each array
    val pq = new scala.collection.mutable.PriorityQueue[Array[Int]]()(arrOrd)
    var (start, end, max) = (0, Int.MaxValue, Int.MinValue)
    for (i <- 0 until nums.size) {
      pq.enqueue(Array(i, 0)) // add to pq
      max = math.max(max, nums(i).head) // find biggest head from all list
    }

    while (pq.size == nums.size) {
      val e = pq.dequeue() // pop the smallest element out
      val (row, col) = (e(0), e(1))
      // start, end is the min,max element in the merge k interval
      // since the pq, so num(e) should be the smallest
      if (end - start > max - nums(row)(col)) {
        // interval too large, to shrink
        start = nums(row)(col)
        end = max // since the max include each list's head ->
      }

      // add next element of the specific row to pq
      if (col + 1 < nums(row).size) {
        pq.enqueue(Array(row, col + 1))
        max = math.max(max, nums(row)(col + 1))
      }
    }
    Array(start, end)
  }

  // TODO
  def main(args: Array[String]) {
    val nums = List(List(4, 10, 15, 24, 26), List(0, 9, 12, 20), List(5, 18, 22, 30))
    val res = smallestRange(nums)
    print(res.toList)
    assert(res sameElements Array(20, 24))
  }

}
