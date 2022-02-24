package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 二叉树镜像
 * @date 2022/2/23 19:30
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        preOrder(root);

        return root;
    }

    private void preOrder(TreeNode node){
        if(node == null){
            return;
        }

        if(node.left != null || node.right != null){
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
        }

        preOrder(node.left);
        preOrder(node.right);

    }

}
