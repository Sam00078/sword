package io.github.chenfh5.common

import scala.collection.mutable


object OwnUtils {

  //递归打印二叉树
  def printTree(root: TreeNode, order: TreeOrder.Order = TreeOrder.preOrder): Unit = {
    if (root == null) return

    if (order == TreeOrder.preOrder) printTreeNode(root)
    printTree(root.left, order)
    if (order == TreeOrder.inOrder) printTreeNode(root)
    printTree(root.right, order)
    if (order == TreeOrder.postOrder) printTreeNode(root)
  }

  /**
    * @see http://blog.csdn.net/jssongwei/article/details/50790253
    *      非递归打印二叉树
    */
  def printTreeNotInRec(root: TreeNode, order: TreeOrder.Order = TreeOrder.preOrder): Unit = {
    if (root == null) return
    if (order == TreeOrder.preOrder) preOrder(root)
    if (order == TreeOrder.inOrder) inOrder(root)
    if (order == TreeOrder.postOrder) postOrder(root)
  }

  private def preOrder(root: TreeNode): Unit = {
    val stack = mutable.Stack[TreeNode]()
    var node = root

    while (node != null || stack.nonEmpty) {
      if (node != null) {
        printTreeNode(node) //
        stack.push(node)
        node = node.left
      } else {
        node = stack.pop()
        node = node.right
      }
    }
  }

  private def inOrder(root: TreeNode): Unit = {
    val stack = mutable.Stack[TreeNode]()
    var node = root

    while (node != null || stack.nonEmpty) {
      if (node != null) {
        stack.push(node)
        node = node.left
      } else {
        node = stack.pop()
        printTreeNode(node) //
        node = node.right
      }
    }
  }

  private def postOrder(root: TreeNode): Unit = {
    val stack = mutable.Stack[TreeNode]()
    val output = mutable.Stack[TreeNode]()
    var node = root

    while (node != null || stack.nonEmpty) {
      if (node != null) {
        stack.push(node)
        output.push(node)
        node = node.right
      } else {
        node = stack.pop()
        node = node.left
      }
    }

    while (output.nonEmpty) {
      printTreeNode(output.pop())
    }
  }

  private def printTreeNode(node: TreeNode): Unit = {
    print(node.value + " ")
  }

}
