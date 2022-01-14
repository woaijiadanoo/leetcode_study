package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    102. 二叉树的层序遍历
 */
public class LevelOrder {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }

        level(root);

        return result;
    }

    private void level(TreeNode node){
        if(node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for(int i=0; i < len; i++){
                TreeNode temp = queue.poll();

                if(temp.left != null){
                    queue.offer(temp.left);
                }

                if(temp.right != null){
                    queue.offer(temp.right);
                }

                level.add(temp.val);
            }

            result.add(level);
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getRoot(new Integer[]{});

        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(root));

    }

}
