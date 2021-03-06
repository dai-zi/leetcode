package com.csms.leetcode.number.n1000.n1020;
//除数博弈
//简单
public class Leetcode1025 {
public boolean divisorGame(int N) {
        //动态规划

        if (N == 1) {
            return false;
        }
        //dp[i]存的是操作数为i时的玩家的获胜情况
        boolean[] dp = new boolean[N+1];

        //初始化dp数组
        dp[1] = false;
        dp[2] = true;

        //遍历3-N并求解整个dp数组
        for (int i = 3; i <= N; i++) {
            //先置dp[i]为false，符合条件则置true
            dp[i] = false;
    
            //玩家都以最佳状态，即玩家操作i后的操作数i-x应尽可能使对手输，即dp[i-x]应尽可能为false 
            //所以遍历x=1~i-1,寻找x的约数，使得dp[i-x]=false，那么dp[i]=true即当前操作数为i的玩家能获胜
            //如果找不到则为false，会输掉
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i-x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
    }
}