package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode != null && rightNode != null){
            return root;
        }

        if(leftNode != null || rightNode != null){
            return leftNode == null ? rightNode : leftNode;
        }

        return null;
    }


}
