package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class SearchTreeLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        if(root.val >= p.val && root.val <= q.val){
            return root;
        }

        if(root.val < p.val){
            return lowestCommonAncestor(root.right, p , q);
        }else{
            return lowestCommonAncestor(root.left, p , q);
        }
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            // 保证 p.val <= q.val，便于后续情况讨论
            return lowestCommonAncestor2(root, q, p);
        }
        if (root.val >= p.val && root.val <= q.val) {
            // p <= root <= q
            // 即 p 和 q 分别在 root 的左右子树，那么 root 就是 LCA
            return root;
        }
        if (root.val > q.val) {
            // p 和 q 都在 root 的左子树，那么 LCA 在左子树
            return lowestCommonAncestor2(root.left, p, q);
        } else {
            // p 和 q 都在 root 的右子树，那么 LCA 在右子树
            return lowestCommonAncestor2(root.right, p, q);
        }
    }

}
