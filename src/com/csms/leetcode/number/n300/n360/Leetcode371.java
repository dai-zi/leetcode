package com.csms.leetcode.number.n300.n360;
//两整数之和
//简单
public class Leetcode371 {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
    }
}