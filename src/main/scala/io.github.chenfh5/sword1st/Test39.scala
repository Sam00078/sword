package io.github.chenfh5.sword1st

import io.github.chenfh5.common.{OwnConstant, TreeNode}


/**
  * 二叉树深度相关问题
  *
  * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
  * 题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过 1 ，那么它就是一棵平衡二叉树。
  *
  * ps.最下面的叶子节点高度是1，根节点的深度是1
  */
object Test39 {

  def getTreeDepth(root: TreeNode): Int = {
    if (root == null) return 0

    val leftDepth = getTreeDepth(root.left)
    val rightDepth = getTreeDepth(root.right)

    if (leftDepth > rightDepth) leftDepth + 1 else rightDepth + 1
  }

  def isBalancedTree(root: TreeNode): Boolean = {
    if (root == null) return true

    val leftDepth = getTreeDepth(root.left)
    val rightDepth = getTreeDepth(root.right)

    if (math.abs(leftDepth - rightDepth) > 1) return false

    //如果`每个结点`的左右子树的深度相差都不超过 1 ，按照定义它就是一棵平衡的二叉树
    isBalancedTree(root.left) && isBalancedTree(root.right)
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    assert(getTreeDepth(input) == 4)
    assert(isBalancedTree(input))

    assert(getTreeDepth(null) == 0)
    assert(isBalancedTree(null))
  }

}
