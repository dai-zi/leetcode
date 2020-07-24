package com.csms.leetcode.number.n1000.n1000;
//十进制整数的反码
//简单
public class Leetcode1009 {
public int bitwiseComplement(int N) {
        int x = N;
        int count = 1;
        while(x>>>1 > 0){
            count++;
            x = x>>>1;
        }
        
        int tmp = 1<<count;
        int res = N ^ (tmp -1);
        return res;

    }
    public static void main(String[] args) {
    }
}