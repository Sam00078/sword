package io.github.chenfh5.collection

import scala.collection.mutable


/**
  * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
  * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
  *
  * @see 泛型的比较需要限定明确边界
  *      https://stackoverflow.com/questions/16506060/scala-repl-error-value-is-not-a-member-of-type-parameter-t
  */
object Test21 {

  class OwnStack[T <% Ordered[T]] { //限定明确边界
    private val dataStack = mutable.Stack[T]()
    private val minStack = mutable.Stack[T]()

    def pop(): T = {
      if (dataStack.isEmpty) throw new RuntimeException("this is an empty stack")

      val topData = dataStack.top
      dataStack.pop()

      if (topData == min()) minStack.pop() //dataStack可能与minStack的size不一致
      topData
    }

    def push(t: T): Unit = {
      if (t == null) throw new RuntimeException("can not push null element")

      dataStack.push(t)
      if (minStack.isEmpty) minStack.push(t)
      else if (t < minStack.top) minStack.push(t) //泛型比较；待入栈数据如果小于minStack的top，就将其入栈

    }


    def min(): T = {
      if (minStack.isEmpty) throw new RuntimeException("this is an empty stack")
      minStack.top
    }
  }

  def main(args: Array[String]): Unit = {
    val ownStack = new OwnStack[Int]()
    ownStack.push(1)
    ownStack.push(2)
    ownStack.push(3)
    ownStack.push(4)
    ownStack.push(3)
    ownStack.push(5)
    ownStack.push(4)
    ownStack.push(3)
    ownStack.push(2)
    ownStack.push(0)

    println(ownStack.min())
    println(ownStack.pop())

    println(ownStack.min())
    println(ownStack.pop())

    println(ownStack.min())
    println(ownStack.pop())

    println(ownStack.min())
    println(ownStack.pop())

    println(ownStack.pop())
    println(ownStack.pop())
    println(ownStack.pop())

    assert(ownStack.pop() == 3)
    assert(ownStack.min() == 1)
  }

}
