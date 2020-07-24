package com.csms.leetcode.number.n100.n160;
//两数之和II_输入有序数组
//简单
public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0, j = numbers.length - 1; i < j; ){
            int sum = numbers[i] + numbers[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}