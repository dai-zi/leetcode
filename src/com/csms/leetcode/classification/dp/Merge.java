package com.csms.leetcode.classification.dp;
//56. 合并区间
public class Merge {
    public int[][] merge(int[][] intervals) {
        int len=intervals.length;
        if(len<2){
            return intervals;
        }
        int temp=0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(intervals[i][0]<=intervals[j][1] && intervals[i][1]>=intervals[j][0]){
                    intervals[j][0]=Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1]=Math.max(intervals[i][1],intervals[j][1]);
                    intervals[i]=null;
                    temp++;
                    break;
                }
            }
        }
        int [][] result=new int[len-temp][2];
        int num=0;
        for(int[] pair:intervals){
            if(pair!=null){
                result[num++]=pair;
            }
        }
        return result;
    }
}
