package io.github.chenfh5.collection

import scala.collection.mutable


/**
  * 输入两个整数序列，第一个序列表示栈的`压入`顺序，请判断二个序列是否为该栈的`弹出`顺序。
  * 假设压入栈的所有数字均不相等。例如序列1 、2、3 、4、5 是某栈压栈序列，
  * 序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
  * 但4、3、5、1、2就不可能是该压栈序列的弹出序列。
  */
object Test22 {

  /**
    * 建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，
    * 并按照第二个序列的顺序依次从该栈中弹出数字。
    * 如果下一个弹出的数字`刚好`是栈顶元素，那么直接弹出，
    * 如果下一个弹出的元素`不在`栈顶，则把`压栈序列`中还没有入栈的数字压入辅助栈，
    * 直到把需要弹出的数字压入栈顶为止。
    * 最终判断辅助栈是否为空，空则是弹出序列，非空则不是弹出序列。
    *
    * @see
    * http://www.codingonway.com/python-stack-push-pop-order.html
    */
  def isPopOrder(inSeq: Array[Int], outSeq: Array[Int]): Boolean = {

    if (inSeq == null || outSeq == null ||
        inSeq.length == 0 || outSeq.length == 0 ||
        inSeq.length != outSeq.length) return false

    val inStack = mutable.Stack[Int]()
    var outIndex = 0

    for (i <- inSeq) {
      inStack.push(i)
      //pushSeq入栈，直到i与popSeq的第pushIndex位相等
      while (inStack.nonEmpty && inStack.top == outSeq(outIndex)) {
        inStack.pop()
        outIndex += 1
      }
    }
    inStack.isEmpty
  }

  def main(args: Array[String]): Unit = {
    val s1 = Array(1, 2, 3, 4, 5)
    val s2 = Array(4, 5, 3, 2, 1)
    val s3 = Array(4, 3, 5, 1, 2)

    assert(isPopOrder(s1, s2))
    assert(!isPopOrder(s1, s3))
  }

}
