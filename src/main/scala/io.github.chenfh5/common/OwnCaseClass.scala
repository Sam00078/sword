package io.github.chenfh5.common

case class LinkNode(
  var value: Int = -99,
  var next: LinkNode = null
)

case class TreeNode(
  var value: Int = -99,
  var left: TreeNode = null,
  var right: TreeNode = null
)

object TreeOrder extends Enumeration {
  type Order = Value
  val preOrder, inOrder, postOrder = Value
}
