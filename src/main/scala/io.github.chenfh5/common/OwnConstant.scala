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

  /**
    * preOrder:1 2 4 9 5 10 3 6 12 7 15
    * inOrder:4 9 2 10 5 1 12 6 3 7 15
    * postOrder:9 4 10 5 2 12 6 15 7 3 1
    *
    *           1
    *      2         3
    *   4     5    6   7
    *    9  10   12     15
    */
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
