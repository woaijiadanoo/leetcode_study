package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/*
    222. 完全二叉树的节点个数
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = 1;
        int rightDepth = 1;

        TreeNode p = root;
        while (p.left!=null){
            leftDepth ++ ;
            p = p.left;
        }

        while (p.right != null){
            rightDepth ++ ;
            p = p.right;
        }

        if(leftDepth == rightDepth){
            return (int)Math.pow(2, leftDepth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,2,7,1,3,6};

        CountNodes countNodes = new CountNodes();
        System.out.println(countNodes.countNodes(BinaryTree.getRoot(input)));
    }

}
