package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.utils.ArrayUtils;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 42. 连续子数组的最大和
 * @date 2022/3/3 15:47
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];

        if(nums==null || nums.length == 0){
            return 0;
        }

        int[] tempArray = new int[nums.length];
        tempArray[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            tempArray[i] = Math.max(nums[i],nums[i]+tempArray[i-1]);
            max = Math.max(max, tempArray[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] input = new int[]{-1,-2};
        MaxSubArray maxSubArray = new MaxSubArray();

        System.out.println(maxSubArray.maxSubArray(input));


    }

}
