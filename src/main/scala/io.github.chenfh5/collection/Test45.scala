package io.github.chenfh5.collection

import scala.collection.mutable.ListBuffer


/**
  * 编号为1,2,3...n的人围成一圈，从第k个人开始报数（从1开始），数到m的人退出。接着下一个人又从`1`开始报数，数到m的人退出，以此类推。
  * 问：剩下的人的编号是多少？
  *this.len=len;//设置环形链表大小
  */
object Test45 {

  /**
    * @see http://www.flyne.org/article/280
    *      http://www.cnblogs.com/xiaodf/p/5027173.html
    * @param n n个人,环形链表大小
    * @param m 数m下然后丢弃
    * @param k 从第k个人开始报数
    */
  def lastRemaining(n: Int = 100, m: Int = 11, k: Int = 1): Int = {
    val arr = ListBuffer(1 to n: _*)
    var dropIndex = k - 1 //表示退出的那个人在arr集合中的下标(0,1,2,..,n-1)

    for (i <- 1 until n) { //要丢弃n-1人
      dropIndex = (dropIndex + m - 1) % arr.length //将要退出的人在集合中的下标
      arr.remove(dropIndex) //将集合中代表该人的元素删除，此时集合长度发生改变
    }
    arr.head
  }

  def main(args: Array[String]): Unit = {
    assert(lastRemaining(2009, 3) == 634)
    assert(lastRemaining(5, 3) == 4)
  }

}
