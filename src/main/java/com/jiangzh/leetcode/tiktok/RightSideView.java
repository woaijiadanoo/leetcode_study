package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode last = queue.peek();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode parent = queue.poll();
                if(parent.right != null){
                    queue.offer(parent.right);
                }
                if(parent.left != null){
                    queue.offer(parent.left);
                }
            }
            result.add(last.val);
        }


        return result;
    }

}
