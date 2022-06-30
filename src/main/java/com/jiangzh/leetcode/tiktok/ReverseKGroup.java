package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }

        ListNode a,b;
        a = b = head;
        for(int i=0; i<k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }

        ListNode newHeader = reverse(a,b);

        a.next = reverseKGroup(b,k);
        return newHeader;
    }

    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre, cur, next;
        pre = null; cur = next = a;
        while (cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
