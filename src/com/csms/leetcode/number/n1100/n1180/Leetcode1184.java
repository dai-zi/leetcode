package com.csms.leetcode.number.n1100.n1180;
//公交站间的距离
//简单
public class Leetcode1184 {
public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(distance==null||distance.length==0){
            return 0;
        }
        int sum=0;
        int dis=0;
        for(int i=0;i<distance.length;i++){
            sum+=distance[i];
            if(i>=Math.min(start,destination)&&i<Math.max(start,destination)){
                dis+=distance[i];
            }
        }
        return Math.min(dis,sum-dis);
    }
    public static void main(String[] args) {
    }
}