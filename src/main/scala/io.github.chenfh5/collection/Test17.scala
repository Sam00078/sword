package io.github.chenfh5.collection

import io.github.chenfh5.common.{LinkNode, OwnConstant}


/**
  * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
  */
object Test17 {

  def merge(head1: LinkNode, head2: LinkNode): LinkNode = {
    if (head1 == null) return head2
    if (head2 == null) return head1

    var head1Var = head1
    var head2Var = head2
    val newHead = LinkNode(0, null) //创建新的头节点，然后迭代其next
    var pointer = newHead //指向新链表的最后一个元素

    while (head1Var != null && head2Var != null) {
      if (head1Var.value < head2Var.value) {
        pointer.next = head1Var
        head1Var = head1Var.next
      } else {
        pointer.next = head2Var
        head2Var = head2Var.next
      }
      pointer = pointer.next
    }

    //remains
    if (head1Var != null) pointer.next = head1Var
    if (head2Var != null) pointer.next = head2Var

    newHead.next
  }

  def main(args: Array[String]): Unit = {
    val input1 = OwnConstant().linkHead
    val input2 = OwnConstant().linkHead

    println(merge(input1, input2))
  }

}
