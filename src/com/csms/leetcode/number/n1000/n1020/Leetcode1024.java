package com.csms.leetcode.number.n1000.n1020;
//视频拼接
//中等
public class Leetcode1024 {
public int videoStitching(int[][] clips, int T) {

        //记录上一个的结束值（就是本次的最小起始值）
        int s = 0;
        //记录当前的最大结束值
        int e = 0;
        int count = 0;
        for(int i=0; i<=T; i++){
            e = 0;
            for(int j=0; j<clips.length; j++){
                //满足条件的片段
                if(clips[j][0] <= s){
                    e = Math.max(e, clips[j][1]);
                }
            }
            count++;
            if(e >= T){
                return count;
            }
            s = e;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}