package com.csms.leetcode.number.n1300.n1340;
//有效的快递序列数目
//困难
public class Leetcode1359 {
    int mod=1000000007;
    public int countOrders(int n) {
        long last=1;
        for(int i=1;i<=n;i++){
            //组合 C(2,2*i)
            int c=i*(2*i-1);
            last=(last*c) % mod;
        }
        return (int)last;
    }
    public static void main(String[] args) {
    }
}