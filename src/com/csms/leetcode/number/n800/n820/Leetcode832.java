package com.csms.leetcode.number.n800.n820;
//翻转图像
//简单
public class Leetcode832 {
public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
    public static void main(String[] args) {
    }
}