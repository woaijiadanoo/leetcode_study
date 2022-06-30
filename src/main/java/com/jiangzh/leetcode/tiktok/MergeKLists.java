package com.jiangzh.leetcode.tiktok;

import com.jiangzh.leetcode.chain.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = result;

        for(ListNode header : lists){
            if(header != null){
                queue.add(header);
            }
        }

        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            temp.next = minNode;

            if(minNode.next != null){
                queue.add(minNode.next);
            }

            temp = temp.next;
        }

        return result.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        ListNode[] input = new ListNode[]{l1,l3,l2,l4};

        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(input);
        System.out.println("listNode = " + listNode);

    }

}
