package com.csms.leetcode.number.n600.n640;
//子数组最大平均数I
//简单
public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }
    public static void main(String[] args) {
    }
}