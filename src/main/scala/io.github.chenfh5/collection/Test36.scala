package io.github.chenfh5.collection

/**
  * 数组中的逆序对
  * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
  * 输入一个数组，求出这个数组中的逆序对的总数
  */
object Test36 {

  /**
    * @see http://blog.csdn.net/u011080472/article/details/51262097
    *      http://wiki.jikexueyuan.com/project/for-offer/question-thirty-six.html
    */
  //TODO
  def getPairs(arr: Array[Int]): Int = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input")

    //复制一份数组，辅助空间
    val arrCopy = arr.clone()

    getPairsCount(arr, arrCopy, 0, arr.length - 1)
  }

  def getPairsCount(arr: Array[Int], arrCopy: Array[Int], start: Int, end: Int): Int = {
    if (start == end) {
      arr(start) = arrCopy(start)
      return 0
    }

    //对左右子数组归并排序，排序过程中统计逆序数
    val mid = (start + end) / 2
    val leftCount = getPairsCount(arr, arrCopy, start, mid)
    val rightCount = getPairsCount(arr, arrCopy, mid + 1, end)

    //归并
    val mergeCount = mergeInversePairs(arr, arrCopy, start, mid + 1, end)

    //总的逆序数等于左右子数组中的逆序数加上合并之后的逆序数
    leftCount + rightCount + mergeCount
  }

  //在归并排序过程中统计逆序数
  def mergeInversePairs(arr: Array[Int], arrCopy: Array[Int], leftStart: Int, rightStart: Int, rightEnd: Int): Int = {
    val leftEnd = rightStart - 1
    var indexCopy = rightEnd

    //i,j初始指向子数组的尾部
    var i = leftEnd
    var j = rightEnd

    var count = 0; //逆序数个数

    while (i >= leftStart && j >= rightStart) {
      //由于左边子数组都是递增排序的，如果左边元素大于右边元素，逆序数为整个右子数组的个数
      if (arr(i) > arr(j)) {
        arrCopy(indexCopy) = arr(i)
        indexCopy -= 1
        i -= 1
        count += j - rightStart + 1
      } else {
        arrCopy(indexCopy) = arr(j)
        indexCopy -= 1
        j -= 1
      }
    }

    //复制左子数组剩余元素
    while (i >= leftStart) {
      arrCopy(indexCopy) = arr(i)
      indexCopy -= 1
      i -= 1
    }

    //复制右子数组剩余元素
    while (j >= rightStart) {
      arrCopy(indexCopy) = arr(j)
      indexCopy -= 1
      j -= 1
    }

    //将结果数组替换原数组，参与后续递归的归并排序
    var varRightEnd = rightEnd
    val nElements = rightEnd - leftStart + 1
    for (i <- 0 until nElements) {
      arr(varRightEnd) = arrCopy(varRightEnd)
      varRightEnd -= 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    assert(getPairs(Array(1, 2, 3, 4, 7, 6, 5)) == 3)
    assert(getPairs(Array(6, 5, 4, 3, 2, 1)) == 15)
    assert(getPairs(Array(1, 2, 1, 2, 1)) == 3)
  }

}
