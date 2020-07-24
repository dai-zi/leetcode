package com.csms.leetcode.number.n900.n900;
//RLE迭代器
//中等
public class Leetcode900 {
int[] A;
    int i, q;

    public Leetcode900(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i+1];
            }
        }

        return -1;
}
    public static void main(String[] args) {
    }
}