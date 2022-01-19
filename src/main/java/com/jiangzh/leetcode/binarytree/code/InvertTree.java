package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/*
    226. 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        order(root);

        return root;
    }

    private void order(TreeNode node) {
        if(node == null){
            return;
        }

        order(node.left);
        order(node.right);

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.right = left;
        node.left = right;

    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,2,7,1,3,6,9};

        InvertTree invertTree = new InvertTree();

        System.out.println(invertTree.invertTree(BinaryTree.getRoot(input)));
    }

}
