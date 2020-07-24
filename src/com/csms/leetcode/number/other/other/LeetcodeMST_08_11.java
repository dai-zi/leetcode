package com.csms.leetcode.number.other.other;
//硬币
//中等
public class LeetcodeMST_08_11 {
public int waysToChange(int n) {
        int [] coins=new int[]{25,10,5,1};
        long [] dp=new long[n+1];//对前i个***来说，从中选取若干件来兑换面额j的整钱
        dp[0]=1;//0个***，待兑换金额为0
        for(int i=1;i<=coins.length;i++){//前个i***的情况
            for(int j=coins[i-1];j<=n;j++){//待兑换面额为j
                //根据背包九讲，完全背包正序更新一维数组
                dp[j]+=dp[j-coins[i-1]];//两种可能的方案数之和：1.少使用一个coins[i]的方案数；2.不使用coins[i]的方案数
            }
        }
        return (int)(dp[n]%(1000000007));
    }

    public static void main(String[] args) {
    }
}