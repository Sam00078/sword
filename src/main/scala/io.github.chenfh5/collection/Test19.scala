package io.github.chenfh5.collection

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode, TreeOrder}


/**
  * 输入一个二叉树，该函数输出它的镜像
  */
object Test19 {

  def mirror(root: TreeNode): TreeNode = {
    if (root == null) return root
    else {
      //swap
      val temp = root.left
      root.left = root.right
      root.right = temp

      //递归
      mirror(root.left)
      mirror(root.right)
    }
    root
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    OwnUtils.printTree(input, TreeOrder.preOrder)
    println()
    OwnUtils.printTree(mirror(input), TreeOrder.preOrder) //1 3 7 15 6 12 2 5 10 4 9
  }

}
