package com.jiangzh.leetcode.tiktok;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int minInx = nums.length - 2;
        while (minInx >= 0 && nums[minInx] >= nums[minInx+1]){
            minInx--;
        }

        if(minInx >= 0){
            int bigIndex = nums.length - 1;
            while (bigIndex >= 0 && nums[minInx] >= nums[bigIndex]){
                bigIndex--;
            }
            swap(nums, minInx, bigIndex);
        }

        reverse(nums, minInx+1);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,1};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);

        for (int i=0; i<input.length; i++){
            System.out.print(input[i] + " , ");
        }
    }

}
