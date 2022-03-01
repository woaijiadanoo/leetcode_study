package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 18. 删除链表的节点
 * @date 2022/3/1 17:02
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }

        if(head.val == val){
           return head.next;
        }

        ListNode result = null;
        ListNode temp = head.next;
        ListNode pre = head;
        while (temp != null){
            if(temp.val == val){
                pre.next = temp.next;
                result = pre;
                break;
            }

            pre = temp;
            temp = temp.next;
        }

        return head;
    }

}
