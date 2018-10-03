package io.github.chenfh5.sword1st

import scala.collection.mutable.ListBuffer

import io.github.chenfh5.common.{OwnConstant, TreeNode}


/**
  * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
  * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同
  */
object Test24 {

  class PostOrder() {
    private var list = ListBuffer[Int]()

    def verifySquenceOfPostOrder(root: TreeNode, inputSeq: List[Int]): Boolean = {
      doPost(root)
      list.toList == inputSeq
    }

    def doPost(root: TreeNode): Unit = {
      if (root != null) {
        if (root.left != null) doPost(root.left)
        if (root.right != null) doPost(root.right)
        list += root.value
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    val inputSeq = List(9, 4, 10, 5, 2, 12, 6, 15, 7, 3, 1)
    val postOrder = new PostOrder

    assert(postOrder.verifySquenceOfPostOrder(input, inputSeq))
  }

}
