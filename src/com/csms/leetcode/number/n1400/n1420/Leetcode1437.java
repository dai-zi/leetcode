package com.csms.leetcode.number.n1400.n1420;
//是否所有1都至少相隔k个元素
//中等
public class Leetcode1437 {
public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                if(count<k)
                    return false;
                count = 0;
            }
            else{
                count++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}