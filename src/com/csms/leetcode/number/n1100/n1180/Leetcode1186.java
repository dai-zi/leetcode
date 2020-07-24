package com.csms.leetcode.number.n1100.n1180;
//删除一次得到子数组最大和
//中等
public class Leetcode1186 {
public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] f = new int[len];
        int[] g = new int[len];
        f[0] = arr[0];
        g[0] = -200001;
        for(int i=1;i<len;i++){
            f[i] = Math.max(f[i-1]+arr[i],arr[i]);//其实就是f(i-1)是否<0
            g[i] = Math.max(g[i-1]+arr[i],f[i-1]);
        }
        int res = Integer.MIN_VALUE; 
        for(int i=0;i<len;i++){
            res = Math.max(res,Math.max(f[i],g[i]));
        }
        return res;
    }

    public static void main(String[] args) {
    }
}