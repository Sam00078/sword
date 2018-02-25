package io.github.chenfh5.collection

import scala.collection.mutable


/**
  * 用两个栈(lifo)模拟的队列(FIFO)
  *
  * 用两个栈模拟的队列
  * 用两个核实现一个队列。队列的声明如下，实现它的两个函数appendTail和deleteHead，
  * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
  */
object Test07 {

  class MockQueue[T] {
    private val stackIn = mutable.Stack[T]()
    private val stackOut = mutable.Stack[T]()

    def append(t: T): Unit = {
      stackIn.push(t)
    }

    def delete(): T = {

      /*每一次出队操作，
          1. 如果stackOut还有数据，说明上次倒的还在，这些数据要先被出队
          2. 如果stackOut空了，那么就是stackIn的底先出，即将stackIn倒出来到stackOut，然后stackOut顶出即可
      */
      if (stackOut.isEmpty) {
        while (stackIn.nonEmpty) {
          stackOut.push(stackIn.pop())
        }
      }

      if (stackOut.isEmpty) throw new RuntimeException("this is the no data remaining")
      stackOut.pop()
    }
  }

  def main(args: Array[String]): Unit = {

    val mockQueue = new MockQueue[Int]
    mockQueue.append(1)
    mockQueue.append(2)
    mockQueue.append(3)
    println(mockQueue.delete())
    println(mockQueue.delete())
    mockQueue.append(5)
    println(mockQueue.delete())
    mockQueue.append(4)
    println(mockQueue.delete())
    println(mockQueue.delete())

    println()
    val mockQueueStr = new MockQueue[String]
    mockQueueStr.append("a1")
    mockQueueStr.append("a2")
    mockQueueStr.append("a3")
    println(mockQueueStr.delete())
    println(mockQueueStr.delete())
    mockQueueStr.append("a5")
    println(mockQueueStr.delete())
    mockQueueStr.append("a4")
    println(mockQueueStr.delete())
    println(mockQueueStr.delete())
  }

}
