package me.huqiao.leecode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 参考：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        String  sub = "";
        int max = 0,len = 0;
        for(String ch : s.split("")){
            if(sub.contains(ch)){
                sub = sub.substring(sub.indexOf(ch)+1);
                sub += ch;
                len = sub.length();
            }else{
                sub += ch;
                len++;
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }

    //best
    public int lengthOfLongestSubstring2(String s) {
        int i=0,max = 0;
        char[] chars = s.toCharArray();
        for(int j = 0;j<chars.length;j++){
            for(int k = i;k<j;k++){
                if(chars[j] == chars[k]){
                    i = k + 1;
                    break;
                }
            }
            if(j - i + 1 > max){
                max = j - i + 1;
            }
        }
        return max;
    }
}
