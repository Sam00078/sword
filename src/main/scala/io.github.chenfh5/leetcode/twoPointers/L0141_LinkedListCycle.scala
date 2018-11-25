package io.github.chenfh5.leetcode.twoPointers

import _root_.io.github.chenfh5.leetcode.common.DataStruct.ListNode


object L0141_LinkedListCycle {

  // @see https://leetcode.com/problems/linked-list-cycle/discuss/44489/O(1)-Space-Solution
  // they would meet at a time, e.g., fast finish 2 loop, but slow only 1 loop. they met at this point
  def hasCycle(head: ListNode): Boolean = {
    var (slow, fast) = (head, head)
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next // move step 1 per time
      fast = fast.next.next // move step 2 per time
      if (slow == fast) return true
    }
    false
  }

  def main(args: Array[String]) {
    // TODO: cycle initialization error(stack OOM, dead loop)
    val l1 = ListNode(null, 1)
    val l2 = ListNode(null, 2)
    val l3 = ListNode(null, 3)
    val l4 = ListNode(null, 4)
    val l5 = ListNode(null, 5)

    //    l5.next = l3
    l4.next = l5
    l3.next = l4
    l2.next = l3
    l1.next = l2

    val head = l1
    val res = hasCycle(head)
    print(res)
  }

}
