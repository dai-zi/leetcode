package com.csms.leetcode.number.n1400.n1420;
//有序矩阵中的第k个最小数组和
//困难
public class Leetcode1439 {
    int cnt=0;
    public void help(int[][] mat,int mid,int cur_sum,int index,int k){
        //如果已经超过mid，则总和不可能小于等于mid，直接返回
        if(cur_sum>mid)return;
        //如果组合数已经超过k，则当前k不可能为第k个数组和，直接返回(只要知道>k即可，不管大于多少)
        if(cnt>k)return;
        //满足条件，cnt++，并返回
        if(index==mat.length){
            cnt++;
            return;
        }
        //在第index行进行遍历，因为cur_sum默认是每一行第一个元素的和，所以遍历到第j个数时，
        //需要减去index行第一个数
        for(int j=0;j<mat[0].length;j++){
            help(mat,mid,cur_sum+mat[index][j]-mat[index][0],index+1,k);
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        int m=mat.length,n=mat[0].length;
        //求max中最小和最大数组和
        int lo=0,hi=0;
        for(int i=0;i<m;i++){
            lo+=mat[i][0];
            hi+=mat[i][n-1];
        }
        //low记录最小数组和，作为回溯cur_sum的初始值。
        //如果cur_sum从0开始，则分支过多，会超时，所以使用最小数组和
        int low=lo;
        while(lo<hi){
            cnt=0;
            int mid=(hi-lo)/2+lo;
            help(mat,mid,low,0,k);
            if(cnt>=k)hi=mid;
            else lo=mid+1;
        }
        return lo;
    }
    public static void main(String[] args) {
    }
}