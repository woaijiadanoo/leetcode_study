package com.jiangzh.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 */
public class TwoSumReturnIndex {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Map<Integer,Integer> temp = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            int otherNum = target - nums[i];
            if(temp.containsKey(otherNum)){
                return new int[]{temp.get(otherNum), i};
            }
            temp.put(nums[i], i);
        }
        return null;
    }

}
