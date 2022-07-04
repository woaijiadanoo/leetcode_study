package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.binarytree.base.TreeNode;
import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode rightNode = root.right;

        root.right = root.left;
        root.left = null;

        TreeNode lastRight = root;
        while (lastRight.right != null){
            lastRight = lastRight.right;
        }

        lastRight.right = rightNode;

    }

}
