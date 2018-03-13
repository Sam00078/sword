package io.github.chenfh5.collection

import scala.collection.mutable.ListBuffer

import io.github.chenfh5.common.{OwnConstant, TreeNode}


/**
  * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
  * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
  * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
  */
object Test25 {

  class FindPath {
    private var listWhole = ListBuffer[ListBuffer[Int]]()
    private val listPath = ListBuffer[Int]()

    //类似深度优先遍历（dfs），到了就添加，如果回退就减去
    def findPath(root: TreeNode, number: Int): ListBuffer[ListBuffer[Int]] = {
      var targetVar = number
      if (root == null) return listWhole

      listPath += root.value
      targetVar -= root.value

      if (targetVar == 0 && root.left == null && root.right == null)
        listWhole += listPath.clone()

      findPath(root.left, targetVar)
      findPath(root.right, targetVar)

      listPath.remove(listPath.size - 1)
      listWhole
    }
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    val number = 1 + 3 + 6 + 12
    val result = new FindPath().findPath(input, number)
    assert(result == ListBuffer(ListBuffer(1, 3, 6, 12)))
  }

}
