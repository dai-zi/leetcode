package com.csms.leetcode.number.n1200.n1240;
//铺瓷砖
//困难
public class Leetcode1240 {
    public int tilingRectangle(int n, int m) {
        int[][] dp=new int[15][15];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++) {
                dp[i][j]=i==j?1:i*j;
                for(int p=1;p<i;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[p][j]+dp[i-p][j]);
                for(int p=1;p<j;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[i][p]+dp[i][j-p]);
                for(int x=2;x<i;x++)
                    for(int y=2;y<j;y++)
                        dp[i][j]=Math.min(dp[i][j], dp[x-1][y]+dp[x][j-y]+dp[i-x+1][y-1]+dp[i-x][j-y+1]+1);
            }
        return dp[n][m];
    }
    public static void main(String[] args) {
    }
}