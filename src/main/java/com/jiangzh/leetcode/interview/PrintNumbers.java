package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * @date 2022/3/1 16:17
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] result = new int[max-1];

        for (int i = 1; i < max; i++) {
          result[i-1] = i;
        }

        return result;
    }

}
