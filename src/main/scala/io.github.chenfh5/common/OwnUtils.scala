package io.github.chenfh5.common

object OwnUtils {

  //打印二叉树
  def printTree(root: TreeNode, order: TreeOrder.Order): Unit = {
    if (root != null) {
      if (order == TreeOrder.preOrder) print(root.value + " ")
      printTree(root.left, order)
      if (order == TreeOrder.inOrder) print(root.value + " ")
      printTree(root.right, order)
      if (order == TreeOrder.postOrder) print(root.value + " ")
    }
  }

}
