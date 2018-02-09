package io.github.chenfh5.collection

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode, TreeOrder}


/**
  * 输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
  */
object Test18 {

  def hasSubTree(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == root2) return true

    if (root2 == null) return true
    if (root1 == null) return false

    var result = false

    if (root1.value == root2.value) result = matching(root1, root2)

    if (result) return true

    hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2) //递归
  }

  def matching(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == root2) return true

    if (root2 == null) return true
    if (root1 == null) return false

    if (root1.value == root2.value) {
      return matching(root1.left, root2.left) && matching(root1.right, root2.right)
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    OwnUtils.printTree(input, TreeOrder.preOrder)

    val subTree = TreeNode(2, null, null) //深度1

    subTree.left = TreeNode(4, null, null) //深度2
    subTree.right = TreeNode(5, null, null)

    println(hasSubTree(input, subTree))

  }

}
