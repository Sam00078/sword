package io.github.chenfh5.common

class OwnConstant {

  val linkHead = LinkNode(1,
    LinkNode(2,
      LinkNode(3,
        LinkNode(4,
          LinkNode(5,
            LinkNode(6,
              LinkNode(7,
                LinkNode(8,
                  LinkNode(9, null)
                ))))))))


  val treeRoot: TreeNode = {
    val root = TreeNode(1, null, null) //深度1

    root.left = TreeNode(2, null, null) //深度2
    root.right = TreeNode(3, null, null)

    root.left.left = TreeNode(4, null, null) //深度3
    root.left.right = TreeNode(5, null, null)
    root.right.left = TreeNode(6, null, null)
    root.right.right = TreeNode(7, null, null)

    root.left.left.right = TreeNode(9, null, null)
    root.left.right.left = TreeNode(10, null, null)
    root.right.left.left = TreeNode(12, null, null)
    root.right.right.right = TreeNode(15, null, null)

    root
  }


}

object OwnConstant {
  def apply(): OwnConstant = new OwnConstant()
}
