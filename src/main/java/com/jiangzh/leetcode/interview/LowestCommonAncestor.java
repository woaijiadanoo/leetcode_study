package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        if(left != null || right!= null){
            return left == null ? right : left;
        }

        return null;
    }


}
