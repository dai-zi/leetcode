package com.csms.leetcode.number.other.other;
//最大子矩阵
//困难
public class LeetcodeMST_17_24 {
    public static int[] getMaxMatrix(int[][] matrix) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;
        int[] res = new int[4];
        int max_sum = matrix[0][0];
        for(int row=0; row<ROWS; row++) {
            int[] mrow = matrix[row];
            if(row > 0) {
                int[] mrow0 = matrix[row-1];
                for(int col=0; col<COLS; col++)
                    mrow[col] += mrow0[col];
            }
            for(int row0 = 0; row0 <= row; row0++) {
                int[] mrow0 = row0==0 ? null : matrix[row0-1];
                int sum1 = 0;
                int col0 = 0;
                for(int col=0; col<COLS; col++) {
                    int s = mrow[col];
                    if(mrow0 != null) s -= mrow0[col];
                    if(sum1 > 0) {
                        sum1 += s;
                    } else {
                        sum1 = s;
                        col0 = col;
                    }
                    if(sum1 > max_sum) {
                        max_sum = sum1;
                        res[0] = row0;
                        res[1] = col0;
                        res[2] = row;
                        res[3] = col;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}