package com.csms.leetcode.number.n1400.n1440;
//两个子序列的最大点积
//困难
public class Leetcode1458 {
    int f[][];
    int a1[];
    int a2[];
    int maxPoint;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        f = new int[nums1.length][nums2.length];
        for (int i = 0 ; i < nums1.length ; i++) {
            f[i] = new int[nums2.length];
        }
        a1 = nums1;
        a2 = nums2;
        maxPoint = nums1[0] * nums2[0];
        f[0][0] = nums1[0] * nums2[0];

        for (int i = 0 ; i < nums1.length ; i++) {
            for (int j = 0 ; j < nums2.length ; j++) {
                int curNum = a1[i] * a2[j];
                f[i][j] = curNum;
                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
                    curNum = f[i - 1][j - 1] + a1[i] * a2[j];
                    if (f[i][j] < curNum) {
                        f[i][j] = curNum;
                    }
                }

                if (i >= 1) {
                    if (f[i][j] < f[i - 1][j])
                        f[i][j] = f[i - 1][j];
                }

                if (j >= 1) {
                    if (f[i][j] < f[i][j - 1])
                        f[i][j] = f[i][j - 1];
                }


                if (maxPoint < f[i][j])
                    maxPoint = f[i][j];
            }
        }

        return maxPoint;
    }
    public static void main(String[] args) {
    }
}