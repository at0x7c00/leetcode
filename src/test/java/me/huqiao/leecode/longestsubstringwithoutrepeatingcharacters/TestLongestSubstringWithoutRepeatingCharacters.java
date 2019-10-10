package me.huqiao.leecode.longestsubstringwithoutrepeatingcharacters;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test(){
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1,lswrc.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0,lswrc.lengthOfLongestSubstring(""));
        Assert.assertEquals(1,lswrc.lengthOfLongestSubstring(" "));
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void test2(){
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring2("abcabcbb"));
        Assert.assertEquals(1,lswrc.lengthOfLongestSubstring2("bbbbb"));
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring2("pwwkew"));
        Assert.assertEquals(0,lswrc.lengthOfLongestSubstring2(""));
        Assert.assertEquals(1,lswrc.lengthOfLongestSubstring2(" "));
        Assert.assertEquals(3,lswrc.lengthOfLongestSubstring2("dvdf"));
    }
}
