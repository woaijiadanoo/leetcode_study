package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 105. 从前序和中序遍历序列构造二叉树
 * @description: 106. 从中序和后序遍历序列构造二叉树
 * @date 2022/1/11 14:25
 */
public class BuildTree {

    /**
     * @Author jiangzheng3
     * @Description 105. 从前序和中序遍历序列构造二叉树
     * @Date 2022/1/11 14:27
     * @Param [preorder, inorder]
     * @return com.jiangzh.leetcode.binarytree.base.TreeNode
     */
    public TreeNode buildTreeWithPreAndIn(int[] preorder, int[] inorder) {
                return buildTreeWithPreAndIn(
                        preorder,0,preorder.length-1,
                        inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeWithPreAndIn(
            int[] preorder, int beginPreIndex,int endPreIndex,
            int[] inorder, int beginInIndex,int endInIndex){
        TreeNode root = null;

        root = new TreeNode(preorder[beginPreIndex]);

        int rootIndex = searchIndex(
                inorder, preorder[beginPreIndex], beginInIndex,endInIndex);

        root.left = buildTreeWithPreAndIn(
                preorder,beginPreIndex+1,rootIndex-1,
                inorder,beginInIndex,rootIndex-1);

        root.right = buildTreeWithPreAndIn(
                preorder,beginPreIndex+rootIndex,endPreIndex,
                inorder,rootIndex+1,endInIndex);

        return root;
    }


    private int searchIndex(int[] arrays,int data,int beginIndex,int endIndex){
        for(int i=beginIndex; i<endIndex; i++){
            if(arrays[i] == data){
                return i;
            }
        }

        return -1;
    }

}
