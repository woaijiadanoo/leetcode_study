package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    107. 二叉树的层序遍历 II
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if(root == null){
            return result;
        }

        levelOrderBottom(root, result);

        return result;
    }


    private void levelOrderBottom(TreeNode node,LinkedList<List<Integer>> result) {
        if(node == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for (int i=0; i < len; i++) {
                TreeNode temp = queue.poll();

                if(temp.left != null){
                    queue.offer(temp.left);
                }

                if(temp.right != null){
                    queue.offer(temp.right);
                }

                level.add(temp.val);
            }

            result.addFirst(level);
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getRoot(new Integer[]{3, 9, 20, null, null, 15, 7});

        LevelOrderBottom bottom = new LevelOrderBottom();

        System.out.println("bottom.levelOrderBottom(root) = " + bottom.levelOrderBottom(root));
    }

}
