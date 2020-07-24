package com.csms.leetcode.number.n1000.n1060;

import java.util.ArrayList;
import java.util.List;

//活字印刷
//中等
public class Leetcode1079 {
public  void defs(String s, int []dp, List<String> list, String q){
//然后一个一个字母的回溯，回溯完要记得归位。
        for(int i=0;i<dp.length;i++){
            if(dp[i]==0)continue;
            q+=(char)(i+'A');
            list.add(q);
            dp[i]--;
            defs(s,dp,list,q);
            dp[i]++;
        }

    }
    public int numTilePossibilities(String tiles) {
        int len=tiles.length();
        List<String>list=new ArrayList<>();
        int []dp=new int[26];
//计算每个字母的个数
        for(int i=0;i<len;i++){
            dp[tiles.charAt(i)-(int)'A']++;
        }
        String q="";
        defs(tiles,dp,list,q);
        return list.size();



    }

    public static void main(String[] args) {
    }
}