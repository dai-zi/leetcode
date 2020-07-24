package com.csms.leetcode.number.n1200.n1280;
//将每个元素替换为右侧最大元素
//简单
public class Leetcode1299 {
public int[] replaceElements(int[] arr) {
        int rightMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int t = arr[i];
            arr[i] = rightMax;
            if (t > rightMax)
                rightMax = t;
        }
        return arr;
    }
    public static void main(String[] args) {
    }
}