package com.jiangzh.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 剑指 Offer 48. 最长不含重复字符的子字符串
 *  https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int right=-1,count=0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if(i != 0){
                charSet.remove(s.charAt(i-1));
            }
            while (right+1 < n && !charSet.contains(s.charAt(right+1))) {
                charSet.add(s.charAt(right+1));
                right++;
            }

            count = Math.max(count, right-i+1);
        }

        return count;
    }

}
