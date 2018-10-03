package io.github.chenfh5.sword1st

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode, TreeOrder}


/**
  * 输入两棵二叉树A和B，判断B是不是A的子结构。
  */
object Test18 {

  def isSubTree(root: TreeNode, subRoot: TreeNode): Boolean = {
    if (root == subRoot) return true
    if (subRoot == null) return true
    if (root == null) return false

    var result = false

    if (root.value == subRoot.value && matching(root, subRoot)) return true

    isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot) //递归
  }

  def matching(root: TreeNode, subRoot: TreeNode): Boolean = {
    if (root == subRoot) return true
    if (subRoot == null) return true
    if (root == null) return false

    if (root.value == subRoot.value) {
      return matching(root.left, subRoot.left) && matching(root.right, subRoot.right)
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    OwnUtils.printTree(input, TreeOrder.preOrder)
    println()
    OwnUtils.printTree(input, TreeOrder.inOrder)
    println()
    OwnUtils.printTree(input, TreeOrder.postOrder)
    println()

    val subTree = TreeNode(2, null, null) //深度1
    subTree.left = TreeNode(4, null, null) //深度2
    subTree.right = TreeNode(5, null, null)
    assert(isSubTree(input, subTree))

    val subTree2 = TreeNode(3, null, null) //深度1
    subTree2.left = TreeNode(6, null, null) //深度2
    subTree2.left.left = TreeNode(12, null, null)
    assert(isSubTree(input, subTree2))
  }

}
