package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode n1 = lowestCommonAncestor(root.left,p,q);
        TreeNode n2 = lowestCommonAncestor(root.right,p,q);

        if(n1 != null && n2 != null){
            return root;
        }

        if(n1 == null && n2 == null){
            return null;
        }

        if(n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }

        System.out.println("判断条件不全");
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
