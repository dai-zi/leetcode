package com.csms.leetcode.number.n1300.n1360;
//最接近的因数
//中等
public class Leetcode1362 {
public int[] closestDivisors(int num) {
        int sum1 = num + 1;
        int sum2 = num + 2;
        int[] res1 = getDivisors(sum1);
        int[] res2 = getDivisors(sum2);
        return Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1]) ? res1:res2;
    }
    
    private int[] getDivisors(int sum){
        int num1 = (int) Math.sqrt(sum);
        while (true){
            if (sum % num1 == 0){
                int num2 = sum / num1;
                return new int[]{num1,num2};
            }else {
                num1--;
            }
        }
    }
    public static void main(String[] args) {
    }
}