package io.github.chenfh5.lc.common

object DataStruct {

  case class Interval(
    var start: Int,
    var end: Int
  )

  // Remember: Address Reference!
  case class ListNode(
    var next: ListNode = null,
    var x: Int = 0
  )

  def listNodeInit(array: Array[Int]): ListNode = {
    var head: ListNode = null
    var cur: ListNode = null
    for (element <- array) {
      if (head == null) {
        head = ListNode(null, element)
        cur = head // cur now at head
      }
      else {
        // always redirect the cur A NEW INSTANCE(to make next.next), but head and its next is never redirect instead of its next.next always update
        // (11) -> c2=new ->c1=c2 -> c3=new -> c2=c3
        cur.next = ListNode(null, element) //cur.next is the newly instance
        cur = cur.next // this step to cut cur link head, but cur.next still work, since address reference
      }
    }
    head
  }

}
