package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/*
    654. 最大二叉树
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums,int startIndex,int endIndex){
        if(startIndex > endIndex){
            return null;
        }

        int temp = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=startIndex; i<=endIndex; i++){
            if(nums[i] > temp){
                temp = nums[i];
                maxIndex = i;
            }
        }

        TreeNode maxNode = new TreeNode(temp);

        maxNode.left = buildTree(nums, startIndex, maxIndex-1);
        maxNode.right = buildTree(nums, maxIndex+1, endIndex);

        return maxNode;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,1,6,0,5};
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();

        System.out.println(maximumBinaryTree.constructMaximumBinaryTree(input));

    }

}
