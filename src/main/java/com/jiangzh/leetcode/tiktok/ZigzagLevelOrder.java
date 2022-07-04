package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rightFirst = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                if(rightFirst){
                    linkedList.addLast(temp.val);
                }else{
                    linkedList.addFirst(temp.val);
                }

            }

            result.add(linkedList);
            rightFirst = !rightFirst;
        }

        return result;
    }

}
