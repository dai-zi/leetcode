package com.csms.leetcode.number.other.other;
//小张刷题计划
//中等
public class LeetcodeLCP12 {
public int minTime(int[] time, int m) {
        int n = time.length;
        if(n <= m) return 0;
        int sum = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left < right){
            int mid = (left+right)/2;
            if(isOk(time, mid, m)) right = mid;
            else left = mid+1;
        }
        return left;
    }
    public boolean isOk(int[] time, int k, int m){
        int max = 0;
        int sum = 0;
        int n = time.length;
        for(int i = 0; i < n; i++){
            if(m == 0) return false;
            if(max < time[i]) max = time[i];
            sum += time[i];
            if(sum - max > k){
                i--;
                max = 0;
                m--;
                sum = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}