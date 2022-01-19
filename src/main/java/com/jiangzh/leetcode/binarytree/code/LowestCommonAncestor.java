package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

public class LowestCommonAncestor {

    private boolean hasNode = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        return order(root,p,q);
    }

    private TreeNode order(TreeNode node,TreeNode p,TreeNode q){
        if(node == null){
            return null;
        }

        // TODO
        return null;
    }


    public static void main(String[] args) {
        Integer[] input = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        System.out.println(ancestor.lowestCommonAncestor(BinaryTree.getRoot(input),t5,t4));
    }

}
