package com.jiangzh.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <= 2){
            return result;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            int twoNumTarget = 0 - nums[i];
            twoSum(temp, nums, i+1, twoNumTarget);
            if(temp.size() == 3){
                result.add(temp);
            }else{
                temp = null;
            }
        }

        return result;
    }

    private void twoSum(List<Integer> temp,int[] nums, int leftIndex, int target){
        if(nums.length < 2){
            return;
        }

        int l=leftIndex,r=nums.length-1;
        while (l < r){
            int lValue = nums[l];
            int rValue = nums[r];
            if(lValue + rValue == target){
                temp.add(l);
                temp.add(r);
            }else if(lValue + rValue < target){
                l ++;
            }else if(lValue + rValue > target){
                r ++;
            }
        }

    }

}
