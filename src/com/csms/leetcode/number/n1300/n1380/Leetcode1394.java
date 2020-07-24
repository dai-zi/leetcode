package com.csms.leetcode.number.n1300.n1380;
//找出数组中的幸运数
//简单
public class Leetcode1394 {
public int findLucky(int[] arr){
        int res=-1;
        int []map=new int[501];
        for(int a:arr){
            map[a]++;
        }
        for(int i=1;i<501;i++){
            if(map[i]==i)
                res=Math.max(i,res);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}