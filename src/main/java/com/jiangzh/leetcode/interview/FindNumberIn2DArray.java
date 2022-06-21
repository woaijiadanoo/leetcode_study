package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 04. 二维数组中的查找
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return flag;
        }

        int depths = matrix.length, lengths = matrix[0].length;
        int length = lengths - 1, depth = 0;
        while (depth < depths && length >= 0) {
            int v = matrix[depth][length];
            if(v == target){
                flag = true;
                break;
            }
            if(v > target){
                length -- ;
            }else{
                depth ++ ;
            }
        }


        return flag;
    }

}
