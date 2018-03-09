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
    var pre = head
    var cur = head.next
    while (cur != null) {
      val nextTemp = cur.next
      cur.next = pre

      pre = cur
      cur = nextTemp
    }
    head.next = null
    pre
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().linkHead
    println(reverseLink(input))
  }

}
