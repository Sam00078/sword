package io.github.chenfh5.collection

import io.github.chenfh5.common.{LinkNode, OwnConstant}


/**
  * 反转链表
  *
  * U->V->W->X->Y->Z
  * U<-V<-W<-X<-Y<-Z
  *
  * 0. `cur=V`
  * 1. 记录`next=W`
  * 2. 改变cur的next，`V.next=U`
  * 3. `prev=V`
  * 4. `cur=W`
  */
object Test16 {

  def reverseLink(head: LinkNode): LinkNode = {
    var reverseHead = LinkNode(0, null)

    var curr = head
    var prev = LinkNode(0, null)
    var next = LinkNode(0, null)

    var isFirstNode = true
    while (curr != null) {
      reverseHead = curr //记录当前结点

      next = curr.next //先记录当前的下一个结点，以便待会的cur变化
      //开始反转操作，当前结点的下一个结点指向前驱结点
      if (isFirstNode) {
        curr.next = null
        isFirstNode = false
      }
      else curr.next = prev
      prev = curr //整体右移一位
      curr = next //整体右移一位
    }
    reverseHead
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().linkHead
    println(reverseLink(input))
  }

}
