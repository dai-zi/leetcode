package com.csms.leetcode.number.n1200.n1280;
//有序数组中出现次数超过25%的元素
//简单
public class Leetcode1287 {
public int findSpecialInteger(int[] arr) {
        int before = arr.length / 4;
        for(int i = 0; before < arr.length; i++, before++){
            if(arr[i] == arr[before]) return arr[i];
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
    }
}