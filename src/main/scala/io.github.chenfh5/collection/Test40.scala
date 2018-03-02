package io.github.chenfh5.collection

/**
  * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个只出现一次的数字。
  * 要求时间复杂度是 O(n)，空间复杂度是 O(1)。
  *
  * 例如输入数组{2, 4, 3, 6, 3, 2, 5, 5}，因为只有4、6这两个数字只出现一次，其他数字都出现了两次，所以输出 4 和 6 。
  */
object Test40 {

  /**
    * @see http://wiki.jikexueyuan.com/project/for-offer/question-forty.html
    *      http://blog.csdn.net/ns_code/article/details/27649027
    *      异或运算的一个性质：任何一个数字异或它自己都等于0。
    *      即如果从头到尾依次异或数组中的每一个数字，那么最终的结果就是那个只出现一次的数字，因为那些成对出现两次的数字全部在异或中抵消了。
    */
  def findNumbersAppearanceOnlyOnce(arr: Array[Int]): Set[Int] = {
    if (arr == null || arr.length < 2) throw new IllegalArgumentException("invalid input array")

    var xor = 0
    for (i <- arr) {
      xor ^= i
    }
    val firstBit1Pos = findFirstBit1Pos(xor)

    //split arr into two arrays
    var resultArray = new Array[Int](2)
    for (i <- arr) {
      if (isFirstBit1(i, firstBit1Pos)) resultArray(0) ^= i
      else resultArray(1) ^= i
    }
    resultArray.toSet
  }

  private def findFirstBit1Pos(num: Int): Int = {
    var varNum = num
    var pos = 0
    while ((varNum & 1) == 0 && pos < 32) {
      /**
        * @see https://www.jianshu.com/p/0236b51b903f
        *      >>> 是无符号右移，无论左操作数是正数还是负数，在高位都补"0"
        */
      varNum >>>= 1
      pos += 1
    }
    pos
  }

  private def isFirstBit1(num: Int, pos: Int) = {
    var varNum = num
    varNum >>>= pos
    (varNum & 1) == 1
  }

  def main(args: Array[String]): Unit = {
    assert(findNumbersAppearanceOnlyOnce(Array(2, 4, 3, 6, 3, 2, 5, 5)).subsetOf(Set(4, 6)))
    assert(findNumbersAppearanceOnlyOnce(Array(4, 6, 1, 1, 1, 1)).subsetOf(Set(4, 6)))
    assert(findNumbersAppearanceOnlyOnce(Array(4, 6)).subsetOf(Set(4, 6)))
  }

}
