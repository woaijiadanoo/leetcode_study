package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description:
 */
public class IsBalanced {

    private boolean isbalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        postOrder(root);

        return isbalanced;
    }

    private int postOrder(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftDepth = postOrder(node.left);
        int rightDepth = postOrder(node.right);

        if(!isbalanced){
            return -1;
        }

        if(Math.abs(leftDepth - rightDepth) > 1){
            isbalanced = false;
        }

        return Math.max(leftDepth,rightDepth) + 1;
    }

}
