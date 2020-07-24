package com.csms.leetcode.number.n1200.n1280;
//统计位数为偶数的数字
//简单
public class Leetcode1295 {
public int findNumbers(int[] nums) {
        int res=0;
        for(int i:nums){
            if(String.valueOf(i).length()%2==0){
                res++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
    }
}