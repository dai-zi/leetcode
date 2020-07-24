package com.csms.leetcode.number.other.other;

import java.util.HashMap;
import java.util.Map;

//主要元素
//简单
public class LeetcodeMST_17_10 {
public int majorityElement(int[] nums) {
            
          if(nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int tem = map.get(nums[i]);
                map.put(nums[i],tem+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int mid = nums.length/2;
        for (Integer key:map.keySet()) {
           if(mid < map.get(key)){
              return key;
           }else{
               count =-1;
           }
        }
        return count;

    }
    public static void main(String[] args) {
    }
}