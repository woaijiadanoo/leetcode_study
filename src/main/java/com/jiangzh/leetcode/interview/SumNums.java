package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 64. 求1+2+…+n
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class SumNums {

    int result = 0;

    public int sumNums(int n) {
        boolean flag = n > 1 && sumNums(n-1) > 0;

        result += n;

        return result;
    }

}
