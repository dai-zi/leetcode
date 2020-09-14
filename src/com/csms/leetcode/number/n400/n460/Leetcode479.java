package com.csms.leetcode.number.n400.n460;
//最大回文数乘积
//困难
public class Leetcode479 {
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        //计算给定位数的最大值
        long max = (long)Math.pow(10,n) - 1;
        //从max - 1开始循环，原因见上文
        for(long i = max - 1; i > max / 10; i--){
            //1. 构造回文数
            String s1 = String.valueOf(i);
            long rev = Long.parseLong(s1 + new StringBuilder(s1).reverse().toString());
            //2. 检验该回文数能否由给定的数相乘得到
            for(long x = max; x * x >= rev; x --){
                if(rev % x == 0) return (int)(rev % 1337);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}