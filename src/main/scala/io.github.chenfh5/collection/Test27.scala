package io.github.chenfh5.collection

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeNode, TreeOrder}


/**
  * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
  * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
  */
object Test27 {

  /**
    * @see https://www.jianshu.com/p/7e30fb656d63
    *      该题本质是二叉树的中序遍历(left root right)+双向链表的插入
    * @see https://www.zhihu.com/question/27378693
    */
  //TODO
  def convert(root: TreeNode): TreeNode = {
    if (root == null) return null
    if (root.left == null && root.right == null) return root

    //1 将左子树构造成双链表，并返回链表头节点
    val left = convert(root.left)
    var p = left
    //2 定位至左子树双链表最后一个节点
    while (p != null && p.right != null) {
      p = p.right
    }
    //3
    if (left != null) {
      p.right = root
      root.left = p
    }
    //4
    val right = convert(root.right)
    //5
    if (right != null) {
      right.left = root
      root.right = right
    }
    if (left != null) left else root
  }

  @deprecated
  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    val output = convert(input)
    OwnUtils.printTree(input, TreeOrder.inOrder)
    //    OwnUtils.printTree(output, TreeOrder.inOrder)
  }

}
