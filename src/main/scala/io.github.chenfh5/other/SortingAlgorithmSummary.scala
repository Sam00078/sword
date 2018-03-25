package io.github.chenfh5.other

import java.util
import java.util.Date


/**
  * @see 八大排序算法总结
  *      https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/
  */
object SortingAlgorithmSummary {

  /*1. insert插入排序*/
  def insertSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    //从第一个开始遍历
    for (i <- 0 until arr.length - 1) {
      //接下来的第(i+1)一直与前一位的换,如果大于前位则换,否则结束该轮次.直到对比到第一位
      //asc,若后面的<前面的,则交换
      for (j <- Range(i + 1, 0, -1) if arr(j) < arr(j - 1)) {
        swap(arr, j, j - 1)
      }
    }
    arr
  }

  /*2. shell希尔排序*/
  def shellSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    var gap = arr.length / 2 //使用当前gap进行组内插入排序
    while (gap > 0) {
      //第一组,第二组...,最后一组
      for (i <- 0 until arr.length if i + gap < arr.length) {
        //每一组的insertSort
        for (j <- Range(0, arr.length, gap) if j + gap < arr.length) {
          if (arr(j + gap) < arr(j)) swap(arr, j, j + gap) //asc
        }
      }
      gap /= 2
    }
    arr
  }

  /*3. select选择排序*/
  def selectSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    for (i <- 0 until arr.length) {
      var minPos = i
      for (j <- i + 1 until arr.length if arr(j) < arr(minPos)) {
        //asc
        minPos = j //找出当前i位置的最小值得pos
      }
      if (minPos != i) swap(arr, minPos, i) //交换i与pos
    }
    arr
  }


  /*4. heap堆排序*/
  def heapSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    //堆长度递减
    for (maxPos <- Range(arr.length, 0, -1)) {
      Adjust2MaxHeap(arr, maxPos) //先建大根堆;然后取head与last交换;此时堆长度减一,因违反了大根堆原则需调整之使其仍为大根堆
      swap(arr, 0, maxPos - 1) //堆顶元素(第一个元素)与Kn交换
    }

    /**
      * --2
      * -/ \
      * 5  6
      * 父节点i的左子节点在位置：(2*i+1),类似二叉树(0,[1,2],[3,4,5,6]).若2为parent,1的left是5,2的right是6=2*2+2
      * 父节点i的右子节点在位置：(2*i+2)
      * 子节点i的父节点在位置：floor((i-1)/2)
      */
    def Adjust2MaxHeap(arr: Array[Int], maxPos: Int): Unit = {
      for (parentPos <- Range.inclusive(maxPos / 2, 0, -1) if parentPos * 2 < maxPos) {
        val left = parentPos * 2 //左节点
        val right = if (left + 1 < maxPos) left + 1 else left //右节点

        val maxChildPos = if (arr(left) > arr(right)) left else right //左右节点中的最大值所在位置
        if (arr(maxChildPos) > arr(parentPos)) swap(arr, maxChildPos, parentPos) //asc,大根堆,root always bigger than child
      }
    }

    arr
  }

  /*5. bubble冒泡排序*/
  def bubbleSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    //最大或最小值固定在最后一位,然后不再参与比较
    for (i <- Range(arr.length, 0, -1)) {
      for (j <- 0 until i if j + 1 < arr.length) {
        if (arr(j + 1) < arr(j)) swap(arr, j, j + 1) //asc
      }
    }
    arr
  }


  /*6. quick快速排序*/
  def quickSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")

    def sort(arr: Array[Int], low: Int, high: Int): Unit = {
      if (low >= high) return
      var (left, right) = (low, high)

      val pivot = arr(left) //挖坑1：选取基准,通常选择head或者last
      while (left < right) {
        while (left < right && arr(right) >= pivot) right -= 1
        arr(left) = arr(right) //坑2：由后向前找比pivot小的数,并填入坑1
        while (left < right && arr(left) <= pivot) left += 1
        arr(right) = arr(left) //坑3：由前向后找比pivot大的数,并填入坑2
      }
      //一个while loop下来,将待排序的arr分割成2部分,一部分都小于pivot;另一部分都大于pivot;然后再对子序列递归即可
      arr(left) = pivot //pivot填入坑3，并准备分治递归快排,把小于pivot的子数列和大于pivot的子数列排序
      sort(arr, low, left - 1)
      sort(arr, left + 1, high)
    }

    sort(arr, 0, arr.length - 1)
    arr
  }

  /*7. merge归并排序*/
  def mergeSort(arr: Array[Int]): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")

    def merge(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
      var (i, j, k) = (0, 0, 0)
      val result = new Array[Int](arr1.length + arr2.length) //申请额外的空间存储合并后的数组
      while (i < arr1.length && j < arr2.length) {
        //选取两个序列中的较小值放入新数组
        val a1Lta2 = arr1(i) < arr2(j)
        result(k) = if (a1Lta2) arr1(i) else arr2(j)
        if (a1Lta2) i += 1 else j += 1
        k += 1
      }
      //序列1中多余的元素移入新数组
      while (i < arr1.length) {
        result(k) = arr1(i)
        k += 1
        i += 1
      }
      //序列2中多余的元素移入新数组
      while (j < arr2.length) {
        result(k) = arr2(j)
        k += 1
        j += 1
      }
      result
    }

    if (arr.length <= 1) return arr
    val mid = arr.length / 2
    val leftArr = arr.slice(0, mid)
    val rightArr = arr.slice(mid, arr.length)
    merge(mergeSort(leftArr), mergeSort(rightArr))
  }

  /**
    * 8. radix基数排序
    *
    * @see https://blog.csdn.net/yabber0914/article/details/52279537
    */
  def radixSort(arr: Array[Int], radix: Int = 10): Array[Int] = {
    if (arr == null || arr.length < 1) throw new IllegalArgumentException("invalid input array")
    val temp = new Array[Int](arr.length) //用于暂存元素
    val radixCnt = new Array[Int](radix) //用于记录待排序元素的信息,用来表示该位是i的数的个数

    val maxDigit = arr.max.toString.length
    var divide = 1
    for (i <- 0 until maxDigit) {
      util.Arrays.fill(radixCnt, 0) //重置radixCnt数组，开始统计下一个关键字
      arr.copyToArray(temp)

      //分配:计算每个待排序数据的子关键字
      for (j <- 0 until arr.length) {
        val subKey = temp(j) / divide % radix //位数
        radixCnt(subKey) += 1
      }

      //统计:统计radixCnt数组的前j位共有多少个数
      for (j <- 1 until radix) {
        radixCnt(j) = radixCnt(j) + radixCnt(j - 1)
      }

      //收集:按子关键字对指定的数据进行排序，因为开始是从前往后放，现在从后往前读取，保证基数排序的稳定性
      for (j <- Range.inclusive(arr.length - 1, 0, -1)) {
        val subKey = temp(j) / divide % radix
        radixCnt(subKey) -= 1
        arr(radixCnt(subKey)) = temp(j)
      }
      divide *= radix //1,10,100,1000
    }
    arr
  }

  def main(args: Array[String]) {
    //all in `asc` sort type
    println(new Date().toString)
    val begin = System.currentTimeMillis()
    println(s"insertSort=${insertSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"  shellSort=${shellSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"selectSort=${selectSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"    heapSort=${heapSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"bubbleSort=${bubbleSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"  quickSort=${quickSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"  mergeSort=${mergeSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"  radixSort=${radixSort(Array(6, 5, 7, 4, 1, 2, 3, 8, 10, 9)).toSeq}")
    println(s"end at ${System.currentTimeMillis() - begin}ms")
  }

  def swap(arr: Array[Int], left: Int, right: Int): Unit = {
    val temp = arr(left)
    arr(left) = arr(right)
    arr(right) = temp
  }

}
