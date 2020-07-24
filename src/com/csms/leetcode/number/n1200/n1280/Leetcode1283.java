package com.csms.leetcode.number.n1200.n1280;
//使结果不超过阈值的最小除数
//中等
public class Leetcode1283 {
public int smallestDivisor(int[] nums, int threshold) {

   int left=1;//除数能取到的最小值
        int max_nums=nums[0];
        for(int i=0;i<nums.length;i++){
            max_nums=Math.max(nums[i],max_nums);
        }
        int right=max_nums;//再大也没有意义了，都是1+1+1...
        int mid=-1, res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(helper(nums,mid,threshold)){right=mid-1;res=mid;}//满足条件，为了找左边界，继续向左半区间缩小
            else left=mid+1;//不满足条件，除数还不够大
        }
        return res;
    }
    public boolean helper(int [] nums,int mid,int threshold){
        int sum=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]%mid==0) sum+=nums[i]/mid;
           else sum+=(nums[i]/mid+1);
           if(sum>threshold) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}