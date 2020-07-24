package com.csms.leetcode.number.n1300.n1300;
//子数组异或查询
//中等
public class Leetcode1310 {
public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i=1;i<arr.length;i++)
            arr[i]=arr[i]^arr[i-1];
        int [] res = new int[queries.length];
        for (int i=0;i<queries.length;++i){
            if (queries[i][0]>0)
                res[i]=arr[queries[i][1]]^arr[queries[i][0]-1];
            else
                res[i]=arr[queries[i][1]];
        }
        return res;
    }

    public static void main(String[] args) {
    }
}