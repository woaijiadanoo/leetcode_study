package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        ListNode dummay = new ListNode(-1);
        dummay.next = head;
        /*
            1 2 3 4 5
         */
        ListNode slow=dummay, fast=dummay;
        int temp = n;
        while (temp > 0) {
            // 长度不够
            if(fast == null || fast.next == null){
                return head;
            }
            fast = fast.next;
            temp -- ;
        }

        while (fast != null && fast.next !=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummay.next;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        int input = 1;

        RemoveNthFromEnd nthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = nthFromEnd.removeNthFromEnd(root, input);

        ListNode.print(listNode);
    }

}
