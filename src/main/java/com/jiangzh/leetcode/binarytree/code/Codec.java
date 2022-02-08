package com.jiangzh.leetcode.binarytree.code;

import com.jiangzh.leetcode.binarytree.base.BinaryTree;
import com.jiangzh.leetcode.binarytree.base.TreeNode;

import java.util.LinkedList;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 序列化二叉树
 * @date 2022/2/8 14:23
 */
public class Codec {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1,2,3,null,null,4,5};
        TreeNode root = BinaryTree.getRoot(vals);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("data = " + data);

        TreeNode deserialize = codec.deserialize(data);
        System.out.println("deserialize = " + BinaryTree.preOrder(deserialize));

    }

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();

        if(root == null){
            return sb.append("null").toString();
        }

        serialize(root, sb);

        return sb.toString().substring(0, sb.length() - 1);
    }

    public void serialize(TreeNode node, StringBuffer sb){
        if(node == null){
            sb.append("#").append(",");
            return;
        }

        sb.append(node.val).append(",");

        serialize(node.left, sb);
        serialize(node.right, sb);

    }

    public TreeNode deserialize(String data) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        for(String val : data.split(",")){
            linkedList.offerLast(val.equals("#") || val.equals("null") ? null : new TreeNode(Integer.parseInt(val)));
        }

        TreeNode root = deserialize(linkedList);

        return root;
    }

    public TreeNode deserialize(LinkedList<TreeNode> linkedList){
        if(linkedList == null || linkedList.size() == 0){
            return null;
        }

        TreeNode root = linkedList.pollFirst();

        if(root == null){
            return null;
        }

        root.left = deserialize(linkedList);
        root.right = deserialize(linkedList);

        return root;
    }
}
