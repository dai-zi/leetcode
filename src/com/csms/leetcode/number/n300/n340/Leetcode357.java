package com.csms.leetcode.number.n300.n340;
//计算各个位数不同的数字个数
//中等
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;

        //bit for pos
        for (int i = 2; i <= n; i++) {
            int count = 1;
            for (int j = 1; j <= i; j++) {
                if (j >= 3) count *= (11 - j);
                else count *= 9;
            }

            res += count;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}