package com.jiangzh.leetcode.chain.base;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 链表
 * @date 2022/2/16 15:28
 */
public class ListNode {

    public int val;
    public ListNode pre;
    public ListNode next;

    public ListNode(){

    }
    public ListNode(int val){
        this.val = val;
    }

    public static void print(ListNode root){
        ListNode cur = root;
        int i = 1;
        while (true) {
            if(cur != null){
                System.out.println("cur "+ i +" = " + cur);
                cur = cur.next;
                i++ ;
            }else{
                break;
            }
        }
    }

    @Override
    public String toString() {
        return this.val+"";
    }
}
