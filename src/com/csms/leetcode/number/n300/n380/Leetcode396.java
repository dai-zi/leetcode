package com.csms.leetcode.number.n300.n380;
//旋转函数
//中等
public class Leetcode396 {
    public int maxRotateFunction(int[] A) {
        int sum=0;
        int len=A.length;
        int p0=0, p1;
        for(int i=0; i<len; i++){
            sum+=A[i];
            p0+=i*A[i];
        }
        int max = p0;
        for(int i=1; i<len; i++){
            p1 = p0 + sum - len * A[len-i];
            max = p1>max?p1:max;
            p0=p1;
        }
        return max;
    }

    public static void main(String[] args) {
    }
}