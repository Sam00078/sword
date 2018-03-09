package io.github.chenfh5.collection

import io.github.chenfh5.common.{OwnConstant, LinkNode}


/**
  * 给定`单向`链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
  * 利用了`引用传递`
  * 删除非尾结点时间复杂读为O(1)，删除尾结点的时间复杂读为O(n), 平均时间复杂度为[(n-1) * O（1）+ 1 * O(N)] / N = (N+N)/N = O(1)
  */
object Test13 {

  def deleteNote(head: LinkNode, toBeDeletedNode: LinkNode): LinkNode = {
    if (head == null || toBeDeletedNode == null) return head

    if (head == toBeDeletedNode) return head.next

    //不少于2个节点的head
    if (toBeDeletedNode.next == null) { //尾巴元素
      var tmp = head
      while (tmp.next != toBeDeletedNode) tmp = tmp.next //find the to be delete node O(n)
      tmp.next = null //then delete it
    } else { //非尾巴元素
      toBeDeletedNode.value = toBeDeletedNode.next.value
      toBeDeletedNode.next = toBeDeletedNode.next.next //挖空了delete node的值 [1->2->3->4] -> [1->3->->4]
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val head = OwnConstant().linkHead

    println(head)
    //     println(deleteNote(head, null)) //full
    //     println(deleteNote(head, head)) //rm1
    //     println(deleteNote(head, head.next)) //rm2
    //     println(deleteNote(head, head.next.next)) //rm3
    println(deleteNote(head, head.next.next.next)) //rm4
    //    println(deleteNote(head, head.next.next.next.next)) //rm5
    //    println(deleteNote(head, head.next.next.next.next.next)) //full

  }

}
