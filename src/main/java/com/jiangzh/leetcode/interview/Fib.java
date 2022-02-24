package com.jiangzh.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @date 2022/2/16 14:21
 */
public class Fib {

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        Integer temp = null;
        if((temp = cache.get(temp)) == null){
            temp = fib(n-1) + fib(n-2);
            cache.put(n,temp);
        }else{
            return temp;
        }

        return temp;
    }


}
