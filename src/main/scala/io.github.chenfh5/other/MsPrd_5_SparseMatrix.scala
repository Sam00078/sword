package io.github.chenfh5.other

import scala.collection.mutable


object MsPrd_5_SparseMatrix {

  /**
    * @see https://www.jianshu.com/p/cc70cefa885b
    *      http://blog.csdn.net/jmspan/article/details/51205354
    *
    *      * **** |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    *      * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
    *      * ***************** | 0 0 1 |
    */
  def sum(sm1: Array[Array[Int]], sm2: Array[Array[Int]], op: Char = '*'): Array[Array[Int]] = {
    if (sm1 == null || sm2 == null ||
        sm1.length < 1 || sm1.head.length < 1 ||
        sm2.length < 1 || sm2.head.length < 1) throw new IllegalArgumentException("invalud input")

    val sm1RowN = sm1.length
    val sm1ColN = sm1.head.length
    val sm2RowN = sm2.length
    val sm2ColN = sm2.head.length

    if (sm1ColN != sm2RowN) throw new IllegalArgumentException("invalud input") //sm1 col== sm2 row

    val wrapMap = new mutable.HashMap[Int, mutable.Map[Int, Int]]()
    val res = Array.ofDim[Int](sm1RowN, sm2ColN) //(sm1RowN,sm1ColN) * (sm2RowN,sm2ColN) = (sm1RowN,sm2ColN)

    //用一个HashMap保存sm2中每一行非0元素，以及他们的列号
    for (i <- 0 until sm2RowN) {
      wrapMap.put(i, new mutable.HashMap[Int, Int]()) //每行一个map
      for (j <- 0 until sm2ColN) {
        if (sm2(i)(j) != 0) wrapMap.get(i).head.put(j, sm2(i)(j)) //具体行的map，遍历其列的非0元素
      }
    }

    //sm2存放在wrapMap后，开始遍历sm1
    op match {
      case '*' =>
        for (i <- 0 until sm1RowN) {
          for (j <- 0 until sm1ColN) {
            if (sm1(i)(j) != 0) {
              val map = wrapMap.get(j).head //sm1的col对应到sm2的row，即sm2具体行的map
              for (k <- map.keySet) { //sm2的各列
                res(i)(k) += sm1(i)(j) * map.get(k).head //矩阵乘法，乘积res的第i行第k列的元素等于矩阵sm1的第i行的元素与矩阵sm2的第k列对应元素乘积`之和`。
              }
            }
          }
        }
      case '+' =>
        for (i <- 0 until sm1RowN) {
          for (j <- 0 until sm1ColN) {
            if (sm1(i)(j) != 0 || sm2(i)(j) != 0) res(i)(j) += sm1(i)(j) + sm2(i)(j)
          }
        }
      case _ => throw new IllegalArgumentException("invalid input op")
    }
    res
  }

  def main(args: Array[String]): Unit = {
    sum(Array(Array(1, 0, 0), Array(-1, 0, 3)),
      Array(Array(7, 0, 0), Array(0, 0, 0), Array(0, 0, 1))
    ).foreach(e => print(e.toList + ",")) //List(7, 0, 0)List(-7, 0, 3)

    println
    sum(Array(Array(1, 0, 0, 0, 0), Array(0, 1, 0, 0, 0), Array(0, 0, 1, 0, 0), Array(0, 0, 0, 1, 0), Array(0, 0, 0, 0, 1)),
      Array(Array(0, 0, 0, 0, 1), Array(0, 0, 0, 1, 0), Array(0, 0, 1, 0, 0), Array(0, 1, 0, 0, 0), Array(1, 0, 0, 0, 0)),
      '+').foreach(e => print(e.toList + ",")) //List(7, 0, 0)List(-7, 0, 3)

  }

  /**
    *
    */

}
