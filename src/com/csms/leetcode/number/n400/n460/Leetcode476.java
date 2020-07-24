package com.csms.leetcode.number.n400.n460;
//数字的补数
//简单
public class Leetcode476 {
    public int findComplement(int num) {
        int tmp = num;
        int num2 = 1;
        while(tmp>0){
            num2<<=1;
            tmp>>=1;
        }
        num2-=1;
        return num^num2;

    }
    public static void main(String[] args) {
    }
}