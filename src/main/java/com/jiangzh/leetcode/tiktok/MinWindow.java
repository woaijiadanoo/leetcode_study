package com.jiangzh.leetcode.tiktok;

import java.util.HashMap;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindow minWindow = new MinWindow();
        String result = minWindow.minWindow(s, t);
        System.out.println("result = " + result);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        if (isEmpty(s) || isEmpty(t) || s.length() < t.length()){
            return "";
        }

        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left=0,right=0;
        int valid=0;
        int start=0,len=Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    private boolean isEmpty(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }
        return false;
    }

}
