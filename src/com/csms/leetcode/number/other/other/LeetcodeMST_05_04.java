package com.csms.leetcode.number.other.other;
//下一个数
//中等
public class LeetcodeMST_05_04 {
public int oneFigure(int num){
        int fi = 0;
        while(num != 0){
            if((num & 1) == 1){
                fi++;
            }
            num >>= 1;
        }
        return fi;
    }
    public int[] findClosedNumbers(int num) {
        int fi, i;
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;
        if(num == 2147483647){
            return arr;
        }
        fi = oneFigure(num);
        for(i = num + 1; i <= 2147483647; i++){
            int f = oneFigure(i);
            if(fi == f){
                arr[0] = i;
                break;
            }
        }
        for(i = num - 1; i >= 1; i--){
            int f = oneFigure(i);
            if(fi == f){
                arr[1] = i;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
    }
}