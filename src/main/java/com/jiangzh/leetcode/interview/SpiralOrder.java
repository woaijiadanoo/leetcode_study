package com.jiangzh.leetcode.interview;

import com.jiangzh.leetcode.utils.ArrayUtils;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * @date 2022/2/28 15:36
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];

        int left = 0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        int index = 0;

        while (left <= right && top <= bottom){
            for(int i=left; i<=right; i++){
                result[index++] = matrix[top][i];
            }

            for(int i=top+1; i<=bottom; i++){
                result[index++] = matrix[i][right];
            }

            if(left < right && top < bottom){
                for(int i=right-1; i>=left; i--){
                    result[index++] = matrix[bottom][i];
                }

                for(int i=bottom-1; i>=top+1; i--){
                    result[index++] = matrix[i][left];
                }
            }

            left++;
            top++;
            right--;
            bottom--;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder spiralOrder = new SpiralOrder();

        ArrayUtils.printArrays(spiralOrder.spiralOrder(matrix));

    }

}
