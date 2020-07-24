package com.csms.leetcode.classification.dp;

import java.util.HashMap;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if(map.getOrDefault(i,0)==0){
                int left = map.getOrDefault(i-1,0);
                int right = map.getOrDefault(i+1,0);
                map.put(i,left+right+1);
                if(left!=0){
                    map.put(i-left,left+right+1);
                }
                if(right!=0){
                    map.put(i+right,right+left+1);
                }
                max = max>(left+right+1)?max:(left+right+1);
            }
        }
        return max;
    }
}
