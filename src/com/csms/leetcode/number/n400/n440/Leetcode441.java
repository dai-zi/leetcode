package com.csms.leetcode.number.n400.n440;
//排列硬币
//简单
public class Leetcode441 {
    public int arrangeCoins(int n) {
        int i=1;
        while(n>=i){
            n-=i++;
        }
        return i-1;
    }
    public static void main(String[] args) {
    }
}