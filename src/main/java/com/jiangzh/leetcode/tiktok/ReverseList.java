package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }

}
