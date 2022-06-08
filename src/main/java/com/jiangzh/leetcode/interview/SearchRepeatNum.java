package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class SearchRepeatNum {

    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] <= target){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }

        int right = i;

        if(j >= 0 && nums[j] != target){
            return 0;
        }

        i=0;
        j=nums.length-1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] < target){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }

        int left = j;

        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{};
        int target = 8;

        SearchRepeatNum repeatNum = new SearchRepeatNum();
        System.out.println(repeatNum.search(input, target));

    }

}
