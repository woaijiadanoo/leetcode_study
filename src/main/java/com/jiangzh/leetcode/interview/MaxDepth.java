package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 55 - I. 二叉树的深度
 * @date 2022/3/3 16:21
 */
public class MaxDepth {

    int max = 0;
    int result = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return max;
        }

        preOrder(root);

        return result;
    }

    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }

        max++;

        result = Math.max(result,max);

        preOrder(node.left);
        preOrder(node.right);

        max--;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = BinaryTree.getRoot(input);


        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(root));


    }

}
