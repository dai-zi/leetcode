package com.csms.leetcode.number.n400.n400;
//第N个数字
//中等
public class Leetcode400 {
    public int findNthDigit(int n) {
        long num=n;

        long size=1;
        long max=9;

        while(n>0){
            //判断不在当前位数内
            if(num-max*size>0){
                num=num-max*size;
                size++;
                max=max*10;
            }else{
                long count=num/size;
                long left=num%size;
                if(left==0){
                    return (int) (((long)Math.pow(10, size-1)+count-1)%10);
                }else{
                    return (int) (((long)Math.pow(10, size-1)+count)/((long)Math.pow(10, (size-left)))%10);
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
    }
}