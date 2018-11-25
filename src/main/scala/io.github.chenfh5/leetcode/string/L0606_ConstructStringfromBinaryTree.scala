package io.github.chenfh5.leetcode.string

object L0606_ConstructStringfromBinaryTree {

  // @see https://leetcode.com/problems/construct-string-from-binary-tree/discuss/103992/Java-Solution-Tree-Traversal/156640
  // preOrder: root->left->right
  def tree2str(t: TreeNode): String = {
    if (t == null) return ""
    val sb = new StringBuilder(t.value.toString)
    if (t.left == null && t.right == null) return sb.toString() // root
    sb.append("(" + tree2str(t.left) + ")") // always have this layer. so left is need, and right is need too, but if right is null, it would be unnecessary empty parenthesis. each node wrap with a pair parenthesis
    if (t.right != null) sb.append("(" + tree2str(t.right) + ")")
    sb.toString()
  }

  def main(args: Array[String]) {
    val t = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)
    t.left = t2
    t.right = t3
    t2.right = t4
    val res = tree2str(t)
    print(res)
    assert(res == "1(2()(4))(3)")
  }

  case class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

}
