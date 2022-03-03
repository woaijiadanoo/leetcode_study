package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @date 2022/3/3 16:01
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> floor = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                floor.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            result.add(floor);
        }

        return result;
    }

}
