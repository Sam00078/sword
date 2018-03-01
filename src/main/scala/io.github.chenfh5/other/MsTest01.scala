package io.github.chenfh5.other


/**
  * 给出o(n平方)的算法，同时把编程代码完整写出来。不能使用Hash算法。
  * 给定N个链表，每个链表的值单调递增，而且都是正数。求在所有链表中都存在的一个数。没有这样的数，返回-1
  */
object MsTest01 {

  def findCommon(nList: Array[LinkNodeMs]): Int = {
    if (nList == null || nList.length < 2) throw new IllegalArgumentException("invalid input nList")

    var firstLink = nList.head
    var remainLink = nList.drop(1)

    var hitCnt = 1
    var endThisLoop = false

    while (firstLink != null) {
      val firstVal = firstLink.value
      for (i <- remainLink.indices if !endThisLoop) {
        var curLink = remainLink(i)
        if (curLink == null) return -1
        if (curLink.value == firstVal) hitCnt += 1
        else if (curLink.value > firstVal) endThisLoop = true //大于firstVal，就直接跳过之后的所有。继续查找下一轮firstVal
        else {
          while (curLink != null && curLink.value < firstVal) curLink = curLink.next //小于firstVal，则继续右移
          if (curLink == null) return -1
          if (curLink.value == firstVal) hitCnt += 1 //等于firstVal，则计数并continue
        }
      } //end for loop

      if (hitCnt == nList.length) return firstVal
      else {
        hitCnt = 1
        endThisLoop = false
        firstLink = firstLink.next
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val input1 = LinkNodeMs(1,
      LinkNodeMs(2,
        LinkNodeMs(3,
          LinkNodeMs(4,
            LinkNodeMs(5,
              LinkNodeMs(7, null)
            )))))

    val input2 = LinkNodeMs(2,
      LinkNodeMs(3,
        LinkNodeMs(5,
          LinkNodeMs(6,
            LinkNodeMs(7, null)
          ))))

    val input3 = LinkNodeMs(1,
      LinkNodeMs(4,
        LinkNodeMs(5,
          LinkNodeMs(7,
            LinkNodeMs(9, null)
          ))))

    val input = Array(input1, input2, input3)
    assert(findCommon(input) == 5)
    assert(findCommon(Array(input1, input2, null)) == -1)
    assert(findCommon(Array(input1, null, null)) == -1)
    assert(findCommon(Array(null, null, null)) == -1)

  }

}

case class LinkNodeMs(
  var value: Int = -99,
  var next: LinkNodeMs = null
)