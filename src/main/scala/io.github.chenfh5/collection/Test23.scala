package io.github.chenfh5.collection

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

import io.github.chenfh5.common.{OwnConstant, TreeNode}


/**
  * `从上往下`打印出二叉树的每个节点，同层节点`从左至右`打印(即广度优先遍历, Breadth-First-Search）
  *
  * @see
  * https://www.jianshu.com/p/3f9cd81b943a
  */
object Test23 {

  def BFS(root: TreeNode): List[Int] = {
    if (root == null) throw new RuntimeException("tree is null")

    var list = ListBuffer[Int]()
    var queue = mutable.Queue[TreeNode]()

    queue += root

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      list += node.value

      if (node.left != null) queue += node.left
      if (node.right != null) queue += node.right
    }
    list.toList
  }

  def main(args: Array[String]): Unit = {
    val input = OwnConstant().treeRoot
    assert(BFS(input) == List(1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 15))
  }

}
