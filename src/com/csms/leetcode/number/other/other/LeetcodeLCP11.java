package com.csms.leetcode.number.other.other;

import java.util.Arrays;

//期望个数统计
//简单
public class LeetcodeLCP11 {
public int expectNumber(int[] scores) {
       Arrays.sort(scores);//给出的数组可能不是按顺序的
       if(scores.length<2){
           return scores.length;
       }
       int ans=1;
       for(int i=1;i<scores.length;i++){
           if(scores[i]!=scores[i-1]){
               ans++;
           }
       }return ans;
    }
    public static void main(String[] args) {
    }
}