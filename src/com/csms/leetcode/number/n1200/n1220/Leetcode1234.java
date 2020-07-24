package com.csms.leetcode.number.n1200.n1220;

import java.util.Arrays;

//替换子串得到平衡字符串
//中等
public class Leetcode1234 {
public int balancedString(String s) {
    if(s==null || s.length()<=0) return -1;
    int N=s.length();
    //这里用26有的浪费,为了方便写代码,就这样吧
    int[] need=new int[26];
    //初始化为-N/4这样最后得到的大于0的值就是多出来的
    Arrays.fill(need,-N/4);
    int[] cur=new int[26];
    for(int i=0;i<N;i++){
        need[s.charAt(i)-'A']++;
    }
    //有几个字符多出来了
    int needCount=0; 
    for(int i=0;i<need.length;i++){
        if(need[i]>0) needCount++;
    } 
    if(needCount==0) return 0;
    int res=N;
    int left=0,right=0;
    int matchCount=0;
    //无脑套路滑窗
    while(right<s.length()){
        char c=s.charAt(right);
        if(need[c-'A']>0){
            cur[c-'A']++;
            if(cur[c-'A']==need[c-'A']){
                matchCount++;
            }
        }
        while(left<=right && matchCount==needCount){
            res=Math.min(right-left+1,res);
            char cl=s.charAt(left);
            if(need[cl-'A']>0){
                cur[cl-'A']--;
                if(cur[cl-'A']<need[cl-'A']){
                    matchCount--;
                }
            }
            left++;
        }
        right++;
    }
    return res;
}

    public static void main(String[] args) {
    }
}