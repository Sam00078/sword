package io.github.chenfh5.collection

import scala.collection.mutable

import _root_.io.github.chenfh5.common.{OwnConstant, LinkNode}


/**
  * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
  */
object Test05 {

  def reverseWithStack(root: LinkNode) = {
    val stack = new mutable.Stack[LinkNode]()
    var oldRoot = root
    /*add*/
    while (oldRoot != null) {
      stack.push(oldRoot)
      oldRoot = oldRoot.next
    }

    /*pick*/
    val queue = new mutable.Queue[Int]()
    while (stack.nonEmpty) {
      val curRoot = stack.pop()
      queue += curRoot.value
    }
    queue
  }

  def main(args: Array[String]) {
    val root = OwnConstant().linkHead

    println(root)
    val reverseRoot = reverseWithStack(root)
    println(reverseRoot)
  }

}
