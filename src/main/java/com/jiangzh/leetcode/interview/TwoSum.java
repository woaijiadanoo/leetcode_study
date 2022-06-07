package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 57. 和为s的两个数字
 * @date 2022/3/4 14:59
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        if(nums == null || nums.length == 0){
            return result;
        }

        int minIndex = 0;
        int maxIndex = nums.length-1;

        while (minIndex <= maxIndex){
            int sum = nums[minIndex] + nums[maxIndex];
            if(sum > target){
                maxIndex --;
            }else if(sum < target){
                minIndex ++ ;
            }else{
                result[0] = nums[minIndex];
                result[1] = nums[maxIndex];
                return result;
            }
        }

        return result;
    }


}
