package com.csms.leetcode.number.n1100.n1120;

import java.util.Arrays;

//等价多米诺骨牌对的数量
//简单
public class Leetcode1128 {
public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}