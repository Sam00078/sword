package io.github.chenfh5.sword1st

/**
  * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
  * 2～10为数字本身；A为1；J为11、Q为12、K为13；大小王可以看成任意数字。
  */
object Test44 {

  /**
    * @see http://wiki.jikexueyuan.com/project/for-offer/question-forty-four.html
    *      http://blog.csdn.net/jarvan_song/article/details/52416039
    */
  def isContinuous(arr: Array[Int]): Boolean = {
    if (arr == null || arr.length != 5) return false

    val arrSort = arr.sortWith(_ < _)
    val zeroCnt = arrSort.count(_ == 0)

    var small = zeroCnt //第一个非0元素的位置
    var big = small + 1
    var gapCnt = 0
    while (big < arrSort.length) {
      if (arrSort(small) == arrSort(big)) return false
      gapCnt += (arrSort(big) - arrSort(small) - 1)
      small = big
      big += 1
    }
    gapCnt <= zeroCnt //缺的<=万能的
  }

  def main(args: Array[String]): Unit = {
    assert(isContinuous(Array(1, 3, 2, 5, 4)))
    assert(!isContinuous(Array(1, 3, 2, 6, 4)))
    assert(isContinuous(Array(0, 3, 2, 6, 4)))
    assert(isContinuous(Array(3, 0, 0, 0, 0)))
    assert(isContinuous(Array(0, 0, 0, 0, 0)))
    assert(!isContinuous(Array(1, 0, 0, 1, 0)))
  }

}
