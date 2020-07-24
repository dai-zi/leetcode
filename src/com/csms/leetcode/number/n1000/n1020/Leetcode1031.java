package com.csms.leetcode.number.n1000.n1020;
//两个非重叠子数组的最大和
//中等
public class Leetcode1031 {
public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int lRight = L-1;
        int lSum = 0, mInitSum = 0;;
        
        for (int i = 0; i <L-1;i++) {
            lSum += A[i];
        }
        for (int i = 0; i <M-1;i++) {
            mInitSum += A[i];
        }

        int result = -1;
        for (int lLeft = 0;lRight<A.length;lLeft++, lRight++) {
            lSum += A[lRight];
            int mRight = M-1;
            int mSum = mInitSum;
            for (int mLeft = 0;mRight<A.length;mLeft++, mRight++) {
                mSum += A[mRight];
                if (mRight < lLeft || mLeft > lRight) {
                    if (mSum + lSum > result) {
                        result = mSum + lSum;
                    }
                }
                mSum -= A[mLeft];
            }    
            lSum -= A[lLeft];
        }
        return result;
    }


    public static void main(String[] args) {
    }
}