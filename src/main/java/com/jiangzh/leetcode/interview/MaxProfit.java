package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 63. 股票的最大利润
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int length = prices.length;
        int db[][] = new int[length][2];

        for(int i=0; i<length; i++){
            if(i == 0){
                db[i][0] = 0;
                db[i][1] = -prices[i];
                continue;
            }

            db[i][0] = Math.max(db[i-1][0], db[i-1][1] + prices[i]);
            db[i][1] = Math.max(db[i-1][1], -prices[i]);
        }

        return db[length-1][0];
    }

}
