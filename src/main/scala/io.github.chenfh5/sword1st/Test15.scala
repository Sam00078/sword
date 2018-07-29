package io.github.chenfh5.sword1st

import io.github.chenfh5.common.{LinkNode, OwnConstant}


/**
  * 题目：输入一个链表，输出该链表中`倒数第k个结点`。
  * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
  * 例如一个链表有 6 个结点，从头结点开始它们的值依次是 1 、2、3、4、5 、6。这个个链表的倒数第 3 个结点是值为 4 的结点。
  */
object Test15 {

  /**
    * 1 2 3 4 5 6 7 8 9 （lastN=4）
    * 1st
    * x
    * y
    * 2nd
    * x
    * ------y(k-1)
    * 3rd
    * ----------x(target)
    * ----------------y(last)
    * xy相差`lastN-1`,然后y与x同时向右移动直到y到达尾巴，此时x所指是所求
    */
  def findLastNPosition(head: LinkNode, lastN: Int): LinkNode = {

    if (head == null || lastN < 1) return null

    var x, y = head
    //y先走`k-1`步
    for (i <- 1 until lastN) {
      if (y.next != null) y = y.next
      else return null
    }

    //xy同时移动
    while (y.next != null) {
      x = x.next //target
      y = y.next
    }
    x
  }

  def main(args: Array[String]): Unit = {
    val head = OwnConstant().linkHead

    println(findLastNPosition(head, 1))
    println(findLastNPosition(head, 2))
    println(findLastNPosition(head, 3))
    println(findLastNPosition(head, 5))
    println(findLastNPosition(head, 8))
    println(findLastNPosition(head, 9))
    println(findLastNPosition(head, 11))
  }

}
