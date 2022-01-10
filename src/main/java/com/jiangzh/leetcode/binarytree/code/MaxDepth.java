package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;
import jdk.nashorn.internal.ir.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public int maxDepth01(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depths = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            depths ++;
        }

        return depths;
    }

    int depth = 0;
    int res = 0;

    public int maxDepth02(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode node){
        if(node == null){
            return;
        }

        depth ++ ;

        res = Math.max(res, depth);

        traverse(node.left);
        traverse(node.right);

        depth -- ;
    }

    public static void main(String[] args) {
        Integer[] treeVals = new Integer[]{0,2,4,1,null,3,-1,5,1,null,6,null,8};
        MaxDepth maxDepth = new MaxDepth();

//        System.out.println(maxDepth.maxDepth01(BinaryTree.getRoot(treeVals)));
        System.out.println(maxDepth.maxDepth02(BinaryTree.getRoot(treeVals)));

    }

}
