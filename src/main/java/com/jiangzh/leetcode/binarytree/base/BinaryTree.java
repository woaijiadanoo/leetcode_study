package com.jiangzh.leetcode.binarytree.base;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    /**
     * 根结点
     */
    private static TreeNode root = null;
    private static final Integer DEFAULT_VALUE=9999;

    public static TreeNode getRoot(Integer[] treeVals){
        if(treeVals == null){
            return root;
        }

        if(treeVals.length > 0){
            root = new TreeNode(treeVals[0]);
        }

        TreeNode[] nodes = new TreeNode[treeVals.length];

        if(treeVals.length == 1){
            nodes[0] = root;
            return root;
        }

        for(int i=1; i< treeVals.length; i++){
            Integer temp = treeVals[i] == null ? DEFAULT_VALUE : treeVals[i];
            insertTreeNode(root, new TreeNode(temp));
        }

        clearTreeNode(root);

        return root;
    }

    private static void insertTreeNode(TreeNode root, TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i=0; i<length; i++){
                TreeNode node = queue.poll();
                if(node.val == DEFAULT_VALUE){
                    continue;
                }
                if(node.left == null){
                    node.left = treeNode;
                    return;
                }else if(node.right == null){
                    node.right = treeNode;
                    return;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    private static void clearTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.left!=null && treeNode.left.val == DEFAULT_VALUE){
            treeNode.left = null;
        }else{
            clearTreeNode(treeNode.left);
        }

        if(treeNode.right!=null && treeNode.right.val == DEFAULT_VALUE){
            treeNode.right = null;
        }else{
            clearTreeNode(treeNode.right);
        }
    }

}
