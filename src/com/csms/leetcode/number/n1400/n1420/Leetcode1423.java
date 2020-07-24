package com.csms.leetcode.number.n1400.n1420;
//可获得的最大点数
//中等
public class Leetcode1423 {
public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, scoreR = 0, scoreL = 0;
        for(int i = 0; i < k; i++)
            scoreL += cardPoints[i];
        int res = scoreL;
        for(int l = 1; l <= k; l++){
            scoreL -= cardPoints[k - l];
            scoreR += cardPoints[n - l];
            res = Math.max(res, scoreR + scoreL);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}