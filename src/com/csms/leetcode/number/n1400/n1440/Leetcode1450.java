package com.csms.leetcode.number.n1400.n1440;
//在既定时间做作业的学生人数
//简单
public class Leetcode1450 {
public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans=0;
        int l=startTime.length;
        for(int i=0;i<l;i++){
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime){
                ans++;
            }
        }return ans;
    }
    public static void main(String[] args) {
    }
}