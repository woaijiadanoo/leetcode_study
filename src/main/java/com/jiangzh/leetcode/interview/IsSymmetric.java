package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 28. 对称的二叉树
 * @date 2022/2/24 14:06
 */
public class IsSymmetric {
    boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        preOrder(root.right,root.left);
        return flag;
    }

    public void preOrder(TreeNode right,TreeNode left){
        if(!flag || (right == null && left == null)){
            return;
        }

        if(right == null || left == null){
            flag = false;
            return;
        }

        if(right.val != left.val){
            flag = false;
            return;
        }

        preOrder(right.right,left.left);
        preOrder(right.left,left.right);
    }

    public static void main(String[] args) {
        Integer[] init = new Integer[]{};
        TreeNode root = BinaryTree.getRoot(init);

        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(root));

    }

}
