package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description:
 */
public class MovingCount {


    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();

        int sum = movingCount.get(325);
        System.out.println("sum = " + sum);
    }

    boolean[][] visit = null;
    int m = 0;
    int n = 0;
    int k = 0;

    public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0,0);
    }

    public int dfs(int i, int j){
        if(i >= m || j >= n || get(i) + get(j) > k || visit[i][j]){
            return 0;
        }

        visit[i][j] = true;

        return 1 + dfs(i+1,j) + dfs(i,j+1);
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
