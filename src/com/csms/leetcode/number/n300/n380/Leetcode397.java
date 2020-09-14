package com.csms.leetcode.number.n300.n380;
//整数替换
//中等
public class Leetcode397 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;
        if (n <= 3)
            return n - 1;
        if (n % 2 == 0)
            return integerReplacement(n / 2) + 1;
        else
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
    }
    //
    public int integerReplacement1(int n) {
        int count = 0;
        while (n > 1) {
            if ((n & 1) == 0) {//是偶数
                n /= 2;
            } else {//是奇数
                if (((n + 1) & 3) == 0 && n != 3) {//对3求余为0
                    n = n / 2 + 1;
                    count++;
                } else {
                    n--;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
    }
}