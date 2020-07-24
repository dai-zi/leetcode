package com.csms.leetcode.number.n600.n680;
//交替位二进制数
//简单
public class Leetcode693 {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n >>>= 1;
        while(n != 0){
            if((n & 1) == pre)
                return false;
            pre = n & 1;
            n >>>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}