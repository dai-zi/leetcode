package com.csms.leetcode.classification.array;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // ��֤ m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i ��Ҫ����
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i ��Ҫ��С
                iMax = i - 1;
            }
            else { // �ﵽҪ�󣬲��ҽ��߽������г�����������
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // �����Ļ�����Ҫ�����Ұ벿��

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //�����ż���Ļ����ؽ��
            }
        }
        return 0.0;
    }
}