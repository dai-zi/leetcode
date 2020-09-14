package com.csms.leetcode.number.n300.n360;
//超级次方
//中等
public class Leetcode372 {
    public int superPow(int a, int[] b) {
        int c=ol(1337);
        int sum=0;
        for(int i=0;i<b.length;i++)
            sum=(sum*10+b[i])%c;
        sum+=c;
        return q((long)a,sum,1337);
    }

    private int q(long x,int y,int M) {
        long res=1;
        while(y>0) {
            if(y%2>0)
                res=res%M*x%M;
            x=x%M*x%M;
            y/=2;
        }
        return (int)res;
    }

    private int ol(int x) {
        int res=x;
        for(int i=2;i*i<=x;i++) {
            if(x%i==0) {
                res=res-res/i;
                while(x%i==0)
                    x/=i;
            }
        }
        if(x>1) res=res-res/x;
        return res;
    }

    public static void main(String[] args) {
    }
}