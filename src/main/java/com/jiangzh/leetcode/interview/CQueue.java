package com.jiangzh.leetcode.interview;

import java.util.LinkedList;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @date 2022/2/16 14:07
 */
public class CQueue {

    private LinkedList<Integer> stack01;
    private LinkedList<Integer> stack02;

    public CQueue() {
        stack01 = new LinkedList<>();
        stack02 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack01.add(value);
    }

    public int deleteHead() {
        if(stack02.isEmpty()){
            if(stack01.isEmpty()){
                return -1;
            }
            while (!stack01.isEmpty()){
                stack02.add(stack01.pop());
            }
        }

        return stack02.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        cQueue.appendTail(5);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(6);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }

}
