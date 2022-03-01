package com.jiangzh.leetcode.utils;

/**
 * @author jiangzheng3
 * @version 1.0
 * @description: 数组工具类
 * @date 2022/2/28 15:52
 */
public class ArrayUtils {

    public static void printArrays(int[][] input){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<input.length; i++){
            for (int j=0; j<input[i].length;j++){
                sb.append(input[i][j]).append(",");
            }
        }

        System.out.println(sb.toString());
    }

    public static void printArrays(int[] input){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<input.length; i++){
            sb.append(input[i]).append(",");
        }

        System.out.println(sb.toString());
    }

}
