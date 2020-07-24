package com.csms.leetcode.number.n1300.n1340;
//跳跃游戏V
//困难
public class Leetcode1340 {
    int[] arr;
    int n; //数组长度
    int d;
    int[] dp;   //用来存储每个柱子的最大结果
    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.n = arr.length;
        this.d = d;
        dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, getMaxFromOnePoint(i));
        }
        return ans;
    }

    private int getMaxFromOnePoint(int p){
        if(dp[p] != 0)  return dp[p];   //当前柱子已经计算过，直接返回它的值
        // 如果没有，分别计算它往左和往右跳一次可以得到的最大值
        int leftMax = 0;
        int l = 1;  // 往左跳的距离
        while(p-l>=0 && l<=d){
            if(arr[p-l]>=arr[p]){   //遇到了高柱子挡路，只能结束
                break;
            } else{
                if(dp[p-l]==0)  dp[p-l] = getMaxFromOnePoint(p-l);
                leftMax = Math.max(leftMax, dp[p-l]);
                l++;
            }
        }
        // 同理右边
        int rightMax = 0;
        int r = 1;
        while(p+r<n && r<=d){
            if(arr[p+r]>=arr[p]){
                break;
            } else{
                if(dp[p+r]==0)  dp[p+r] = getMaxFromOnePoint(p+r);
                rightMax = Math.max(rightMax, dp[p+r]);
                r++;
            }
        }

        return Math.max(leftMax, rightMax)+1;
    }
    public static void main(String[] args) {
    }
}