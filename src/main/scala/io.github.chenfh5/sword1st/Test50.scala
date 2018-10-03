package io.github.chenfh5.sword1st

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode}


/**
  * 给定一棵二叉树，找到两个节点的最近公共父节点LCA(Lowest Common Ancestor)
  * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度
  */
object Test50 {

  /**
    * @see https://www.hrwhisper.me/algorithm-lowest-common-ancestor-of-a-binary-tree/
    *      https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.03.md
    */

  //lca search binary tree
  def lcaBST(root: TreeNode, a: TreeNode, b: TreeNode): TreeNode = {
    if (root == null) return root
    if (a.value > b.value) return lcaBST(root, b, a) //always: a < b

    if (root.value >= a.value && root.value <= b.value) return root
    if (root.value < a.value) return lcaBST(root.right, a, b) //root比最小的a还小，则可以放大root
    if (root.value > b.value) return lcaBST(root.left, a, b) //root比最大的b还大，则可以减少root
    null
  }

  //lca binary tree
  def lcaBT(root: TreeNode, a: TreeNode, b: TreeNode): TreeNode = {
    if (root == null || a == root || b == root) return root //key for recursion

    val left = lcaBT(root.left, a, b)
    val right = lcaBT(root.right, a, b)

    if (left != null && right != null) return root //如果某个节点的左右子树分别包括这两个节点，那么这个节点必然是所求的解
    if (left != null) left else right //否则，返回左或者右子树
  }

  def main(args: Array[String]): Unit = {

    val root = OwnConstant().treeRoot
    val a = root.left.left.right //9
    val b = root.left.right.left //10

    OwnUtils.printTree(lcaBT(root, a, b)) //2 4 9 5 10
    println()
    OwnUtils.printTree(lcaBT(root, root.right.right.right, root.right.right)) //7 15
  }

}
