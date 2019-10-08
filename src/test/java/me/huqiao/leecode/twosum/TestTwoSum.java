package me.huqiao.leecode.twosum;

import org.junit.Assert;
import org.junit.Test;

public class TestTwoSum {
    @Test
    public void testTwoSum(){
        int array[] = new int[]{12,34,56,77,10};
        int[] res = TwoSum.twoSum(array,22);
        Assert.assertEquals(0,res[0]);
        Assert.assertEquals(4,res[1]);

        int[] res2 = TwoSum.twoSum(array,23);
        Assert.assertEquals(-1,res2[0]);
        Assert.assertEquals(-1,res2[1]);
    }
}
