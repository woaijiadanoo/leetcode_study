package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

import java.util.List;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 24. 反转链表
 * @date 2022/3/1 16:26
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode nhead = head;
        ListNode temp = null;
        while (current.next != null){
            nhead = current.next;
            current.next = temp;
            temp = current;
            current = nhead;
        }

        current.next = temp;

        return nhead;
    }

}
