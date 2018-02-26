package io.github.chenfh5.collection

/**
  * 实现函复制一个复杂链表。在复杂链表中，每个结点除了有一个next字段指向下一个结点外，
  * 还有一个sibling字段指向链表中的任意结点或者NULL
  */
object Test26 {

  def cloneNext(head: ComplexLinkNode): ComplexLinkNode = {
    var varHead = head
    while (varHead != null) {
      var temp = ComplexLinkNode()
      temp.value = varHead.value + 100 //for debug obviously
      temp.next = varHead.next
      varHead.next = temp

      //到些处就已经完成了一个结点的复制并且插入到被复制结点的后面
      varHead = temp.next
    }
    head
  }

  def cloneSibling(head: ComplexLinkNode): ComplexLinkNode = {
    var varHead = head

    if (varHead != null) {
      if (varHead.sibling != null) {
        varHead.next.sibling = varHead.sibling.next //复制结点的sibling`指向`原始节点的sibling的下一个结点
      }
      varHead = varHead.next.next //指向下一个要处理的复制结点
    }
    head
  }

  def splitNode(oriHead: ComplexLinkNode): ComplexLinkNode = {
    var head = oriHead

    if (head == null) return null

    var newHead = head.next //用于记录复制链表的头结点，`复制结点` AA_BB_CC_DD_，A_
    //在while循环处，通过修改pointer来修改newHead，因为pointer，newHead指向的内存地址一样
    //var pointer = newHead.copy() would be error
    var pointer = newHead //用于记录当前处理的复制结点，A_

    head.next = newHead.next //原始节点的next指向下一个原始节点，A->B
    head = head.next //指向新的原始节点, B

    while (head != null && head.next != null) {
      pointer.next = head.next //指向新的原始节点的下一个节点，B_
      pointer = pointer.next //B_

      head.next = pointer.next //head的下一个指向复制结点的下一个结点，C
      head = pointer.next //C
    }
    newHead
  }

  /**
    * @see http://zhedahht.blog.163.com/blog/static/254111742010819104710337/
    *      第二种方法相当于用空间换时间，以O(n)的空间消耗实现了O(n)的时间效率。
    */
  def clone(head: ComplexLinkNode): ComplexLinkNode = {

    if (head == null) return null
    cloneNext(head)
    cloneSibling(head)
    splitNode(head)
  }

  def main(args: Array[String]): Unit = {
    val head = ComplexLinkNode()
    head.value = 1
    head.next = ComplexLinkNode()
    head.next.value = 2
    head.next.next = ComplexLinkNode()
    head.next.next.value = 3
    head.next.next.next = ComplexLinkNode()
    head.next.next.next.value = 4
    head.next.next.next.next = ComplexLinkNode()
    head.next.next.next.next.value = 5

    head.sibling = head.next.next
    head.next.sibling = head.next.next.next.next.next
    //        head.next.next.next.sibling = head.next

    println(head)
    println(clone(head))
  }

}

case class ComplexLinkNode(
  var value: Int = 0,
  var next: ComplexLinkNode = null,
  var sibling: ComplexLinkNode = null
)
