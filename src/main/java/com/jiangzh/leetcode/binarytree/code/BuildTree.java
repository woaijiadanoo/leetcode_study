package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    public static TreeNode buildTreeWithPreAndIn(int[] preorder, int[] inorder) {
                return buildTreeWithPreAndIn(
                        preorder,0,preorder.length-1,
                        inorder,0,inorder.length-1);
    }

    private static TreeNode buildTreeWithPreAndIn(
            int[] preorder, int beginPreIndex,int endPreIndex,
            int[] inorder, int beginInIndex,int endInIndex){
        TreeNode root = null;

        if(beginPreIndex > endPreIndex){
            return null;
        }
        root = new TreeNode(preorder[beginPreIndex]);

        int rootIndex = searchIndex(
                inorder, preorder[beginPreIndex], beginInIndex,endInIndex);

        if(rootIndex == -1){
            System.out.println("中序不正确");
            return null;
        }

        int leftLen = rootIndex - beginInIndex;

        root.left = buildTreeWithPreAndIn(
                preorder,beginPreIndex+1,beginPreIndex+leftLen,
                inorder,beginInIndex,rootIndex-1);

        root.right = buildTreeWithPreAndIn(
                preorder,beginPreIndex+leftLen+1,endPreIndex,
                inorder,rootIndex+1,endInIndex);

        return root;
    }


    private static int searchIndex(int[] arrays,int data,int beginIndex,int endIndex){
        for(int i=beginIndex; i<=endIndex; i++){
            if(arrays[i] == data){
                return i;
            }
        }

        return -1;
    }


    private static Map<Integer, Integer> arrays = new HashMap<>();
    /**
     * @Author jiangzheng3
     * @Description 106. 从中序和后序遍历序列构造二叉树
     * @Date 2022/1/11 14:27
     * @Param [preorder, inorder]
     * @return com.jiangzh.leetcode.binarytree.base.TreeNode
     */
    public static TreeNode buildTreeWithInAndPost(int[] inorder, int[] postorder) {

        for(int i=0; i < inorder.length; i++){
            arrays.put(inorder[i], i);
        }

        return buildTreeWithInAndPost(
                inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    private static TreeNode buildTreeWithInAndPost(
            int[] inorder, int beginInIndex,int endInIndex,
            int[] postorder, int beginPostIndex,int endPostIndex){
        TreeNode root = null;

        if(beginInIndex > endInIndex){
            return null;
        }

        root = new TreeNode(postorder[endPostIndex]);

        /*
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
         */

        int rootIndex = arrays.get(postorder[endPostIndex]);
//        int rootIndex = searchIndex(inorder, postorder[endPostIndex],beginInIndex,endInIndex);
        System.out.println("rootIndex : " + rootIndex);
        int leftLen = rootIndex - beginInIndex;

        root.left = buildTreeWithInAndPost(
                inorder,beginInIndex,rootIndex-1,
                postorder,beginPostIndex,beginPostIndex+leftLen-1);

        root.right = buildTreeWithInAndPost(
                inorder,rootIndex+1,endInIndex,
                postorder,beginPostIndex+leftLen,endPostIndex-1);

        return root;
    }

    public static void main(String[] args) {
        // 105. 从前序和中序遍历序列构造二叉树
//        testPreAndIn();

        // 106. 从中序和后序遍历序列构造二叉树
        testInAndPost();

    }

    private static void testPreAndIn(){
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};

        TreeNode root = buildTreeWithPreAndIn(preOrder, inOrder);

        System.out.println(root);
    }

    private static void testInAndPost(){
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};

        TreeNode root = buildTreeWithInAndPost(inOrder, postOrder);

        System.out.println(root);
    }

}
