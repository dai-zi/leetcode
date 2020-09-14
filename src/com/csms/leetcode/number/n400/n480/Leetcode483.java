package com.csms.leetcode.number.n400.n480;
//最小好进制
//困难
public class Leetcode483 {
    public String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        for (int m = 59; m > 1; m--) {
            long k = (long) Math.pow(N, 1.0 / m);
            //不存在1进制，如果k<=1，直接下一次
            if (k <= 1)
                continue;
            long s = 0;
            for (int i = 0; i <= m; i++)
                s = s * k + 1;
            if (s == N)
                return String.valueOf(k);
        }
        return String.valueOf(N - 1);
    }
    public static void main(String[] args) {
    }
}