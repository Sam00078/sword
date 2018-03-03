package io.github.chenfh5.other


import io.github.chenfh5.common.{LinkNode, OwnConstant}


object ReverseLink {

  /**
    * @see http://blog.csdn.net/guyuealian/article/details/51119499
    *      http://hanhailong.com/2016/02/25/Java%E5%8F%8D%E8%BD%AC%E5%8D%95%E9%93%BE%E8%A1%A8%E5%AE%9E%E6%88%98/
    */
  def reverse(head: LinkNode): LinkNode = {
    if (head == null) return null
    var preNode = head
    var curNode = head.next

    while (curNode != null) {
      val nextNode = curNode.next //save the next node
      curNode.next = preNode //keyPoint: update the value of "next"

      //shift the pointers
      preNode = curNode
      curNode = nextNode
    }
    head.next = null //将原链表的头节点的next置为null。此为新链表的尾结点，即原链表的头结点
    preNode
  }

  /**
    * @see http://blog.csdn.net/guyuealian/article/details/51119499
    *      递归反转法：在反转当前节点之前先反转后续节点。
    *      这样从头结点开始，层层深入直到尾结点才开始反转指针域的指向。
    *      简单的说就是从尾结点开始，逆向反转各个结点的指针域指向。
    */
  def reverseInRecur(head: LinkNode): LinkNode = {
    if (head == null || head.next == null) return head //若为空链或当前是尾结点，则直接还回
    val nextNode = head.next //取出下一个节点
    head.next = null //next置空
    val reverseNode = reverseInRecur(nextNode) //反转下一个节点

    nextNode.next = head //next指向前节点head
    reverseNode //reverseNode的值没有改变，为原链表的最后一个node
  }

  def main(args: Array[String]): Unit = {
    println(OwnConstant().linkHead)
    println(reverse(OwnConstant().linkHead))
    println(reverseInRecur(OwnConstant().linkHead))
  }

}
