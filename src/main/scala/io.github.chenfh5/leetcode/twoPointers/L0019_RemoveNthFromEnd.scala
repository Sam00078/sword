package io.github.chenfh5.leetcode.twoPointers

import _root_.io.github.chenfh5.leetcode.common.DataStruct
import _root_.io.github.chenfh5.leetcode.common.DataStruct.ListNode


object L0019_RemoveNthFromEnd {

  // @see https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in-one-pass/156281
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var (front, back) = (head, head)
    for (i <- 0 until n) front = front.next // from left move n pos
    if (front == null) return head.next // if n more than link size, null
    while (front.next != null) {
      front = front.next // move to the end
      back = back.next // equal that from left move end-n step. If size=6, n=2, now back in pos 4.
    }
    back.next = back.next.next // 直接修改back的地址的next指向,但是这个地址与head共用,所以改变这个地址的next,head已受到同样的影响
    head
  }

  def main(args: Array[String]) {
    val head = DataStruct.listNodeInit(Array(1, 2, 3, 4, 5))
    val res = removeNthFromEnd(head, 2)
    print(res)
  }

}
