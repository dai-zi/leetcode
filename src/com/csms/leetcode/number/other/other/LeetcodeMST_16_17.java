package com.csms.leetcode.number.other.other;
//连续数列
//简单
public class LeetcodeMST_16_17 {
public int maxSubArray(int[] nums) {
        int b = nums[0];
        int sum = b;
        for(int i = 1; i<nums.length;i++){
            if(b<0){
                b=nums[i];
            }else{
                b+=nums[i];
            }
            if(b>sum){
                sum=b;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}