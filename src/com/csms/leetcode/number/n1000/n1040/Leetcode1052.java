package com.csms.leetcode.number.n1000.n1040;
//爱生气的书店老板
//中等
public class Leetcode1052 {
//思路 先求出原本就满意的客户数  再利用滑动窗口求出X区间内 所有不满意的用户 两者相加就是最大满意数
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        int originCount = 0;
        int maxAngryCount = 0;
        //前缀和
        int[] sum = new int[grumpy.length + 1];
        
        for(int i = 0;i< grumpy.length;i++ ){
             if(grumpy[i] == 0){
                 originCount += customers[i];
                 sum[i+1] = sum[i];
             }else{
                 sum[i+1] = sum[i] + customers[i];;
             }
        }
        //[i,i+X) 
        for(int i = 0;i< grumpy.length - X + 1;i++ ){
             maxAngryCount = Math.max(maxAngryCount,sum[i+X] - sum[i]);
        }
        return originCount +maxAngryCount;
    }
    public static void main(String[] args) {
    }
}