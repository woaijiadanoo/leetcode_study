package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * @date 2022/2/16 15:28
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode first = head;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }

        ListNode temp = l1 == null ? l2 : l1;
        if(temp != null){
            head.next = temp;
        }

        return first.next;
    }

}
