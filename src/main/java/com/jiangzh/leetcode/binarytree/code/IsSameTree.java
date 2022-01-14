package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

public class IsSameTree {

    Boolean flag = true;

    public Boolean isSameTree(TreeNode p, TreeNode q) {
        if (!flag) {
            return flag;
        }

        if(p == null && q == null){
            return flag = true;
        }

        if((p == null && q != null) || (p != null && q == null)){
            return flag = false;
        }

        if(p.val != q.val){
            return flag = false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode p = BinaryTree.getRoot(new Integer[]{1,2,3});
        TreeNode q = BinaryTree.getRoot(new Integer[]{1,2,4});

        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(p,q));

    }

}
