package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLargest {

    int result = 0;
    int k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;

        reversalInOrder(root);

        return result;
    }

    private void reversalInOrder(TreeNode node){
        if(node == null){
            return;
        }

        reversalInOrder(node.right);

        if(k == 0){return;}
        if(--k == 0){
            result = node.val;
            return;
        }

        reversalInOrder(node.left);

    }


    public static void main(String[] args) {
        Integer[] input = new Integer[]{5,3,6,2,4,null,null,1};

        TreeNode root = BinaryTree.getRoot(input);

        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargest(root, 3));

    }

}
