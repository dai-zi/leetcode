package com.csms.leetcode.number.other.other;
//拿硬币
//简单
public class LeetcodeLCP06 {
public int minCount(int[] coins) {
        int count = 0;
        for(int i = 0,len = coins.length;i<len;i++){
            if((coins[i]&1) == 0){
                count += coins[i]/2;
            }else{
                count++;
                count += coins[i]/2;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}