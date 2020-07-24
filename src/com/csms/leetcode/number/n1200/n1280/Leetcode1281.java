package com.csms.leetcode.number.n1200.n1280;
//整数的各位积和之差
//简单
public class Leetcode1281 {
public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product *= num;
            n /= 10;
        }
        return product - sum;
    }
    public static void main(String[] args) {
    }
}