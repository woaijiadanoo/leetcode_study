package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @date 2022/3/4 15:32
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int[]> resultList = new ArrayList<>();

        int i=1,j=1,sum=0;
        while (i <= target/2){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else if(sum == target){
                int[] temp = new int[j-i];
                int index = 0;
                for(int n=i; n<j; n++){
                    temp[index++] = n;
                }
                resultList.add(temp);

                sum -= i;
                i++;
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }


    public static void main(String[] args) {
        int input = 9;
        FindContinuousSequence sequence = new FindContinuousSequence();

        ArrayUtils.printArrays(sequence.findContinuousSequence(input));
//        ArrayUtils.printArrays(sequence.findContinuousSequence2(input));


    }

}
