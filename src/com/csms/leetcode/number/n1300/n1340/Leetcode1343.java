package com.csms.leetcode.number.n1300.n1340;
//大小为K且平均值大于等于阈值的子数组数目
//中等
public class Leetcode1343 {
public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0 ,result=0;
        int sumTarget = k*threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int adder = sum - sumTarget;
        if (adder >= 0) {
            result++;
        }
        int pos = k;
        for (int i = 0; i < arr.length-k; i++) {
            adder = adder+arr[pos]-arr[i];
            if (adder>=0){
                result++;
            }
            pos++;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}