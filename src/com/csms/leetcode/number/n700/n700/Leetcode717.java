package com.csms.leetcode.number.n700.n700;
//1比特与2比特字符
//简单
public class Leetcode717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
    public static void main(String[] args) {
    }
}