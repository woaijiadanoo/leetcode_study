package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow=head,fast=head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(newHead);

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode result = temp;
        while (leftHead != null && rightHead != null){
            if(leftHead.val <= rightHead.val){
                temp.next = leftHead;
                leftHead = leftHead.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        temp.next = leftHead == null ? rightHead : leftHead;

        return result.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l4.next = l2;
        l2.next = l1;
        l1.next = l3;

        SortList sortList = new SortList();
        ListNode result = sortList.sortList(l4);
        ListNode.print(result);
    }

}
