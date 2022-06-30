package com.jiangzh.leetcode.tiktok;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 */
public class MySqrt {

    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1 || x == 2){
            return 1;
        }
        int l=0,r=x;
        int result = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if(((long)mid * mid) == x){
                return mid;
            }else if(((long)mid * mid) < x){
                l = mid + 1;
                result = mid;
            }else{
                r = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 8;
        MySqrt mySqrt = new MySqrt();
        int result = mySqrt.mySqrt(x);
        System.out.println("result = " + result);
    }

}
