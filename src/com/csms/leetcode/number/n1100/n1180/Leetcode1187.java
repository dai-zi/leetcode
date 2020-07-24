package com.csms.leetcode.number.n1100.n1180;

import java.util.Arrays;

//使数组严格递增
//困难
public class Leetcode1187 {
    public  static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length==0)
            return -1;
        Arrays.sort(arr2);
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[][] dp = new int[length1][length1+1];

        dp[0][0] =  arr1[0];
        dp[0][1] = Math.min(arr1[0],arr2[0]);
        for(int i=1;i<length1;i++){
            int index1 = get2(dp[i-1][i],arr2);
            for(int j=i+1;j>=0;j--){
                int a,b;
                a = arr1[i]>dp[i-1][j==i+1?i:j] ? arr1[i] : Integer.MAX_VALUE;//不换a[i]
                index1 = j>0?get(dp[i-1][j-1],index1,arr2):length2;
                b = j!=0 && index1<length2 ?arr2[index1]:Integer.MAX_VALUE;// 换a[i]
                dp[i][j] = Math.min(a,b);
            }
        }
        int re = -1;
        for(int i=0;i<=length1;i++){
            if(dp[length1-1][i]<Integer.MAX_VALUE) {
                re = i;
                break;
            }
        }
        return re;
    }

    public static int get(int n,int index,int[] arr){
        while(index<arr.length){
            if(arr[index]>n)
                break;
            index ++;
        }
        return index;
    }

    public static int get2(int n,int[] arr){
        int l=0,r = arr.length-1;
        int re = -1;
        while(r-l>1){
            if(arr[l+r>>1]>n){
                r = l+r>>1;
            }else{
                l = l+r>>1;
            }
        }
        if(arr[l]>n)
            re = l;
        else
            re = l+1;
        return re;
    }
    public static void main(String[] args) {
    }
}