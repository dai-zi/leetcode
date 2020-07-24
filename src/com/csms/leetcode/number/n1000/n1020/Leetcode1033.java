package com.csms.leetcode.number.n1000.n1020;
//移动石子直到连续
//简单
public class Leetcode1033 {
public int[] numMovesStones(int a, int b, int c) {
        int[] res=new int[2];
        int temp;
        if(a>b) {temp=a;a=b;b=temp;}
        if(b>c) { temp=b;b=c;c=temp;}
        if(a>b) {temp=a;a=b;b=temp;}
        int x=a;
        int y=b;
        int z=c;
        if((x>=y || y>=z)||(y-x==1 && z-y==1)){
            res[0]=0;
            res[1]=0;
            return res;
        }
        if(y-x==1 || y-x==2 || z-y==1 || z-y==2){
            res[0]=1;
            res[1]=z-x-2;
            return res;
        }
        res[0]=2;
        res[1]=z-x-2;
        return res;

    }
    public static void main(String[] args) {
    }
}