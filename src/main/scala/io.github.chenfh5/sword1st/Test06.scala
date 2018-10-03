package io.github.chenfh5.sword1st

import io.github.chenfh5.common.{OwnUtils, TreeNode, TreeOrder}


/**
  * 根据先序和中序遍历,还原一个二叉树
  */
object Test06 {


  def construct(preOrderArr: Array[Int], inOrderArr: Array[Int]): TreeNode = {
    if (preOrderArr == null || inOrderArr == null || preOrderArr.length != inOrderArr.length || inOrderArr.length < 1) return null

    reConstruct(preOrderArr, 0, preOrderArr.length - 1, inOrderArr, 0, inOrderArr.length - 1)

  }

  private def reConstruct(preOrderArr: Array[Int], pStart: Int, pEnd: Int, inOrderArr: Array[Int], iStart: Int, iEnd: Int): TreeNode = {
    if (pStart > pEnd) return null //开始位置大于结束位置说明已经没有需要处理的元素了

    val rootValue = preOrderArr(pStart)
    var iIndex = iStart

    while (iIndex <= iEnd && inOrderArr(iIndex) != rootValue) iIndex += 1 //在中序遍历的数组中直到找根结点的位置iIndex

    if (iIndex > iEnd) throw new RuntimeException("Invalid input") //如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常

    val newRoot = TreeNode(0, null, null)
    newRoot.value = rootValue

    //left right sub-tree 中序分
    val leftTreeSize = iIndex - iStart
    newRoot.left = reConstruct(preOrderArr, pStart + 1, pStart + leftTreeSize,
      inOrderArr, iStart, iIndex - 1) //首位的的root不要

    newRoot.right = reConstruct(preOrderArr, pStart + leftTreeSize + 1, pEnd,
      inOrderArr, iIndex + 1, iEnd) //中间的root不要

    newRoot
  }

  def main(args: Array[String]): Unit = {
    val preOrderArr = Array(1, 2, 4, 7, 3, 5, 6, 8)
    val inOrderArr = Array(4, 7, 2, 1, 5, 3, 8, 6)

    val recoveryTree = construct(preOrderArr, inOrderArr)
    OwnUtils.printTree(recoveryTree, TreeOrder.postOrder) //7 4 2 5 8 6 3 1
  }

}
