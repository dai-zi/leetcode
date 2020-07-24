package com.csms.leetcode.number.n100.n160;
//Excel表列名称
//简单
public class Leetcode168 {
    public String convertToTitle(int n) {
        String AZ = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] CZ = AZ.toCharArray();

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(CZ[n % 26]);
            n = n / 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    }
}