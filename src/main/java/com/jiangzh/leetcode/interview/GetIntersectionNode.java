package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.chain.base.ListNode;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA, second = headB;

        while (first != second){
            if(first == null){
                first = headB;
            }else{
                first = first.next;
            }

            if(second == null){
                second = headA;
            }else{
                second = second.next;
            }
        }

        return first;
    }

}
