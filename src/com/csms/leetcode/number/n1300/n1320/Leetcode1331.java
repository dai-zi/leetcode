package com.csms.leetcode.number.n1300.n1320;
//数组序号转换
//简单
public class Leetcode1331 {
public int[] arrayRankTransform(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        int[] count = new int[max - min + 1];
        for (int num : arr)
            count[num - min] = 1;
        
        int[] preSum = new int[count.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + count[i - 1];
        
        int[] ans = new int[arr.length];
        int index = 0;
        for (int num : arr) 
            ans[index++] = preSum[num - min] + 1;
        
        return ans;
    }
    public static void main(String[] args) {
    }
}