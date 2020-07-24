package com.csms.leetcode.number.n1400.n1440;
//形成两个异或相等数组的三元组数目
//中等
public class Leetcode1442 {
public int countTriplets2(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            for(int k = i + 1; k < arr.length; k++){
                temp ^= arr[k];
                if(temp == 0)
                    count += k - i;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}