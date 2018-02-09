package io.github.chenfh5.common

case class LinkNode(
  var value: Int,
  var next: LinkNode
)

case class TreeNode(
  var value: Int,
  var left: TreeNode,
  var right: TreeNode
)

object TreeOrder extends Enumeration {
  type Order = Value
  val preOrder, inOrder, postOrder = Value
}
