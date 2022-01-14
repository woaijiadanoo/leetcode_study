package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        levelOrder(result,root);

        return result;
    }

    private void levelOrder(List<List<Integer>> result,TreeNode node){
        if(node == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        boolean flag = true;

        while (!queue.isEmpty()){
            LinkedList<Integer> linkedList = new LinkedList<>();
            int len = queue.size();
            for(int i=0; i < len; i++){
                TreeNode temp = queue.poll();

                if(temp.left != null){
                    queue.offer(temp.left);
                }

                if(temp.right != null){
                    queue.offer(temp.right);
                }

                if(!flag){
                    linkedList.addFirst(temp.val);
                }else{
                    linkedList.addLast(temp.val);
                }
            }
            flag = !flag;
            result.add(linkedList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getRoot(new Integer[]{3, 9, 20, null, null, 15, 7});

        ZigzagLevelOrder order = new ZigzagLevelOrder();
        System.out.println(order.zigzagLevelOrder(root));

    }

}
