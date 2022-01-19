package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    111. 二叉树最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        int depth = 1;

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0; i < len ; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth ++ ;
        }
        return depth;
    }


}
