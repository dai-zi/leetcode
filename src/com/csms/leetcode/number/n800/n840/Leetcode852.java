package com.csms.leetcode.number.n800.n840;
//山脉数组的峰顶索引
//简单
public class Leetcode852 {
public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }
    public static void main(String[] args) {
    }
}