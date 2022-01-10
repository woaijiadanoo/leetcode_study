package com.jiangzh.leetcode.binarytree.base;

/***
 * 二叉树结点
 * @date 2020/12/18
 * @author xuning
 * @param <E>
 */
public class TreeNode {
    Integer val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(){};
    TreeNode(Integer val) { this.val = val; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
