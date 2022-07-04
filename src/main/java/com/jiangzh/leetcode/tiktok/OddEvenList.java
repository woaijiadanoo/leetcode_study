package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode evenHeader = head.next;

        ListNode oddNode = head;
        ListNode evenNode = evenHeader;
        while (evenNode != null && evenNode.next != null){
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHeader;

        return head;
    }

}
