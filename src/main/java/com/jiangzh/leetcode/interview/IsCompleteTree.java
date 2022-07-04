package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 958. 二叉树的完全性检验
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 */
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp == null){
                    flag = true;
                }else{
                    if(flag){
                        return false;
                    }

                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }

        return true;
    }

}
