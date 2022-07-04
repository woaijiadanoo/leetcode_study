package com.jiangzh.leetcode.tiktok;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int right=-1;
        int counts=0;
        int n = s.length();
        for (int i=0; i<n; i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }

            while (right+1 < n && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }

            counts = Math.max(counts, right-i+1);

        }

        return counts;
    }

}
