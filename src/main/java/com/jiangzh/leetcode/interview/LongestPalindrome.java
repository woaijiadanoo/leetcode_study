package com.jiangzh.leetcode.interview;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s == null || s.trim().length() == 0 || s.trim().length() == 1){
            return s;
        }
        String result = "";
        for(int i=0; i<s.length(); i++){
            String odd = palindrome(s, i, i);
            String event = palindrome(s, i, i+1);

            result = result.length() > odd.length() ? result : odd;
            result = result.length() > event.length() ? result : event;
        }

        return result;
    }


    private String palindrome(String s, int l, int r){
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }

        return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        String input = "cbbd";

        LongestPalindrome longestPalindrome = new LongestPalindrome();

        String s = longestPalindrome.longestPalindrome(input);


        System.out.println("s = " + s);
    }

}
