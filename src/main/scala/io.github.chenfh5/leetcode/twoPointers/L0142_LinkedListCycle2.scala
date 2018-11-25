package io.github.chenfh5.leetcode.twoPointers

import _root_.io.github.chenfh5.leetcode.common.DataStruct.ListNode


object L0142_LinkedListCycle2 {

  // @see https://www.cnblogs.com/hiddenfox/p/3408931.html
  // @see https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C++-with-Detailed-Alogrithm-Description
  def detectCycle(head: ListNode): ListNode = {
    var (slow, fast, entry) = (head, head, head)
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next // move step 1 per time
      fast = fast.next.next // move step 2 per time
      if (slow == fast) {
        // there is a cycle
        while (slow != entry) {
          // slow distance = a + b, fast distance = a + b + c + b => a=c
          // if it is a cycle, there always a entry
          // found the entry location
          slow = slow.next
          entry = entry.next
        }
        return entry
      }
    }
    null
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
    val res = detectCycle(head)
    print(res)
  }

}
