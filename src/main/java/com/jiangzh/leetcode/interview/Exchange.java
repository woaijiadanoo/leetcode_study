package com.jiangzh.leetcode.interview;

import com.google.gson.Gson;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @date 2022/2/24 14:30
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int oddIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (oddIndex == -1) {
                    oddIndex = i;
                }
            } else {
                if(oddIndex == -1){
                    continue;
                }
                int temp = nums[oddIndex];
                nums[oddIndex++] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};

        Exchange exchange = new Exchange();
        System.out.println(new Gson().toJson(exchange.exchange(input)));

    }

}
