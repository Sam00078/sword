package io.github.chenfh5.collection

import io.github.chenfh5.common.LinkNode


/**
  * 输入两个链表，找出它们的第一个公共节点（这里是公共节点，不是第一个数值）
  */
object Test37 {

  /**
    * @see http://zhedahht.blog.163.com/blog/static/254111742008053169567/
    *
    *      先行法：分别求出二者的长度，求出二者的差dis，
    *      而后将指向长的链表的指针先在长链表上走dis步，
    *      而两个链表同时走，二者会同时走到第一个公共节点处
    *
    *      如果两个单向链表有公共的结点，也就是说两个链表从某一结点开始，它们的m_pNext都指向同一个结点。但由于是单向链表的结点，每个结点只有一个m_pNext，因此从第一个公共结点开始，之后它们所有结点都是重合的，不可能再出现分叉。所以，两个有公共结点而部分重合的链表，拓扑形状看起来像一个Y，而不可能像X。
    */
  def findCommonNode(head1: LinkNode, head2: LinkNode): LinkNode = {
    var varHead1 = head1
    var varHead2 = head2

    val head1Size = getLinkNodeSize(varHead1)
    val head2Size = getLinkNodeSize(varHead2)
    val diff = math.abs(head1Size - head2Size)

    if (head1Size > head2Size) {
      for (i <- 0 until diff) {
        varHead1 = varHead1.next
      }
    } else {
      for (i <- 0 until diff) {
        varHead2 = varHead2.next
      }
    }

    while (varHead1 != null && varHead2 != null && varHead1 != varHead2) {
      varHead1 = varHead1.next
      varHead2 = varHead2.next
    }
    varHead1
  }

  private def getLinkNodeSize(head: LinkNode): Int = {
    var varHead = head
    var size = 0
    while (varHead != null) {
      size += 1
      varHead = varHead.next
    }
    size
  }

  def main(args: Array[String]): Unit = {
    val head1 = LinkNode(1,
      LinkNode(2,
        LinkNode(3,
          LinkNode(6,
            LinkNode(7, null)
          ))))

    val head2 = LinkNode(4,
      LinkNode(5,
        LinkNode(6,
          LinkNode(7, null)
        )))

    val res = LinkNode(6,
      LinkNode(7, null)
    )

    assert(findCommonNode(head1, head2) == res)
  }

}
