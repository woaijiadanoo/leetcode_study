package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 链表中倒数第k个节点
 * @date 2022/2/28 16:04
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = head;
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (index == k) {
                result = result.next;
            } else {
                index++;
            }
            temp = temp.next;
        }

        return result;
    }

}
