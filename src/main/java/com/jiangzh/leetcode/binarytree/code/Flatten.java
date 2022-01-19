package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/*
    114. 二叉树展开为链表
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        order(root);

        System.out.println(root);
    }

    public void order(TreeNode node){
        if(node == null){
            return;
        }
        order(node.left);
        order(node.right);

        TreeNode right = node.right;
        TreeNode left = node.left;
        node.left = null;

        TreeNode p = node;
        node.right = left;

        while (p.right != null){
            p = p.right;
        }

        p.right = right;

    }


    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,5,3,4,null,6};

        Flatten flatten = new Flatten();
        flatten.flatten(BinaryTree.getRoot(input));

    }

}
