package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description:
 */
public class ReverseTest {

    ListNode reverse(ListNode a){
        ListNode pre,cur,next;
        pre=null; cur=a; next=a;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ReverseTest reverseTest = new ReverseTest();
        ListNode result = reverseTest.reverse(a1);

        ListNode.print(result);
    }



}
