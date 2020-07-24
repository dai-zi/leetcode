package com.csms.leetcode.number.n1000.n1000;
//子串能表示从1到N数字的二进制串
//中等
public class Leetcode1016 {
public boolean queryString(String S, int N) {
        for(int i=Math.max(1,N/2);i<=N;i++)
        {
            if(S.indexOf(Integer.toBinaryString(i))==-1)
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}