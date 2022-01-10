package com.jiangzh.leetcode.binarytree.base;

public class BinaryTreeMain {

    public static void main(String[] args) {
        Integer[] treeVals = new Integer[]{0,2,4,1,null,3,-1,5,1,null,6,null,8};
        TreeNode root = BinaryTree.getRoot(treeVals);
//        System.out.println(root);
        preOrder(BinaryTree.getRoot(treeVals));

    }

    private static void preOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.println("treeNode = "+ treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

}
