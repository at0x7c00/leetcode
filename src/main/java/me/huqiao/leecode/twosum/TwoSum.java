package me.huqiao.leecode.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int index = 0;
        for(int num : nums){
            Integer x = map.get(target - num);
            if( x != null){
                return new int[]{x,index};
            }
            map.put(num,index);
            index++;
        }
        return new int[]{-1,-1};
    }
}
