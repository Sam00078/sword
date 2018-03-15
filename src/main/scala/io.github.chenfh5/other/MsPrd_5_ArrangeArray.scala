package io.github.chenfh5.other

object MsPrd_5_ArrangeArray {

  /**
    * @see http://blog.csdn.net/qq_25850819/article/details/79205889
    */
  def arrange(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 2) return arr

    var (left, mid) = (0, 0)
    var right = arr.length - 1
    while (mid <= right) { //O(n)
      if (arr(mid) < 0) { //mid始终 >= left
        swap(arr, left, mid)
        left += 1
        mid += 1
      }
      else if (arr(mid) > 0) {
        swap(arr, mid, right)
        right -= 1
      }
      else mid += 1
    }
    arr
  }

  def condiction(arr: Array[Int], pos: Int): Boolean = {
    if (arr(pos) > 0) true else false
  }

  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }

  def main(args: Array[String]): Unit = {
    assert(arrange(Array(0, 2, 4, 3, 1, 0, -3, -1, -2)).toSeq == Seq(-2, -1, -3, 0, 0, 1, 3, 4, 2))
  }

}
