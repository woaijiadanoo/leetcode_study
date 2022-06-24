package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 07. 重建二叉树
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class BuildTree {

    int[] preorder = null;
    int[] inorder = null;

    Map<Integer, Integer> values = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;


        return build(0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int preStart,int preEnd,int inStart,int inEnd){
        if(preStart > preEnd){
            return null;
        }

        int parentValue = preorder[preStart];
        TreeNode parentNode = new TreeNode(parentValue);

        int parentIndex = getIndex(inorder, parentValue);

        int leftSize = parentIndex - inStart;

        parentNode.left = build(preStart+1,preStart+leftSize, inStart, parentIndex - 1);
        parentNode.right = build(preStart + leftSize + 1,preEnd, parentIndex+1, inEnd);

        return parentNode;
    }

    private int getIndex(int[] arrays, int value){
        if(values == null || values.size() == 0){
            for(int i=0; i<arrays.length; i++){
                values.put(arrays[i], i);
            }
        }

        return values.get(value);
    }

}
