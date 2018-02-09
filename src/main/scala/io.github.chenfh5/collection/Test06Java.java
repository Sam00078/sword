package io.github.chenfh5.collection;

import java.util.Stack;

import javafx.scene.effect.InnerShadow;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 */
public class Test06Java {

    public static class BinaryTreeNode {

        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * BTS构造
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
        //valid check
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || inOrder.length < 1) {
            return null;
        }

        //loop
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * @param preOrder
     * @param ps
     *         start pos
     * @param pe
     *         end pos
     * @param inOrder
     * @param is
     * @param ie
     * @return
     */
    public static BinaryTreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int root = preOrder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inOrder[index] != root) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.value = root;

        //left sub-tree 中序分
        int leftTreeSize = index - is;
        int rightTreeSize = ie - index;

        newNode.left = construct(preOrder, ps + 1, ps + leftTreeSize, inOrder, is, index - 1);

        newNode.right = construct(preOrder, ps + 1 + leftTreeSize, pe, inOrder, index + 1, ie); //中间的root不要
        return newNode;
    }

    //打印二叉树
    public static void printTree(BinaryTreeNode root, int order) {
        if (root != null) {
            if (order == 1) System.out.print(root.value + " ");

            printTree(root.left, order);
            if (order == 2) System.out.print(root.value + " ");

            printTree(root.right, order);
            if (order == 3) System.out.print(root.value + " ");

        }
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root, 1); //preOrder
        System.out.println();
        printTree(root, 2); //inOrder
        System.out.println();
        printTree(root, 3); //postOrder
    }

}