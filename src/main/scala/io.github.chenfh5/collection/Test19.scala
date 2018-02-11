package io.github.chenfh5.collection

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode, TreeOrder}


/**
  * 输入一个二叉树，该函数输出它的镜像
  */
object Test19 {

  def mirror(root: TreeNode): TreeNode = {
    var rootVar = root
    if (root != null) {
      //swap
      var temp = rootVar.left
      rootVar.left = rootVar.right
      rootVar.right = temp

      //递归
      mirror(rootVar.left)
      mirror(rootVar.right)
    }

    rootVar
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    OwnUtils.printTree(input, TreeOrder.preOrder)
    println()
    OwnUtils.printTree(mirror(input), TreeOrder.preOrder)
  }


}
