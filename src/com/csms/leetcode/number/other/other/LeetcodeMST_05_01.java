package com.csms.leetcode.number.other.other;
//插入
//简单
public class LeetcodeMST_05_01 {
public int insertBits(int N, int M, int i, int j) {
         while((i<=j)){
            int bit  = (M&0x01);
            N = (bit== 0)?N&(~(1<< i)):N|(1<< i);        
            M >>= 1;
            i++;
        }
        return N;
    }
    public static void main(String[] args) {
    }
}