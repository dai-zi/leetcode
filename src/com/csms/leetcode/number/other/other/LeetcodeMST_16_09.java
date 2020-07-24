package com.csms.leetcode.number.other.other;
//运算
//中等
public class LeetcodeMST_16_09 {
public LeetcodeMST_16_09() { }
    
    public int minus(int a, int b) {
        String sb = String.valueOf(b);
        if(b > 0){
            b = Integer.parseInt("-"+sb);
        } else if(b < 0){
            b = Integer.parseInt(sb.substring(1, sb.length()));
        }
        return a+b;
    }
    
    public int multiply(int a, int b) {
        if(b == 0)  return 0;
        boolean negative = (a>0&&b<0) || (a<0&&b>0);
        a = Math.abs(a);
        b = Math.abs(b);

        int ans = 0;
        if(b<=10){
            for(int i=0; i<b; i++)  ans += a;
            return negative ? -ans : ans;
        }

        String sb = String.valueOf(b);
        for(int i=sb.length()-1; i>=0; i--){
            int bit = sb.charAt(i)-'0';
            int multi = multiply(a, bit);
            for(int j=0; j<sb.length()-1-i; j++){
                multi = multiply(multi, 10);
            }
            ans += multi;
        }   
        return negative ? -ans : ans; 
    }
    
    public int divide(int a, int b) {
        if(b==1)    return a;
        if(b==-1)   return minus(0, a);
        boolean negative = (a>0&&b<0) || (a<0&&b>0);
        a = Math.abs(a);
        b = Math.abs(b);
        if(a < b)   return 0;

        int ans = 0;
        int cur = 0;
        String sa = String.valueOf(a);
        for(int i=0; i<sa.length(); i++){
            int c = sa.charAt(i)-'0';
            cur = multiply(cur, 10) + c;
            int count = 0;
            while(cur >= b){
                cur = minus(cur, b);
                count++;
            }
            ans = multiply(ans, 10) + count;
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
    }
}