package com.csms.leetcode.number.n1200.n1280;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//顺次数
//中等
public class Leetcode1291 {
public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i+1;j <= 9; j++){
                num = num*10+j;
                if(num>= low && num<= high){
                    res.add(num);
                }
                if(num>=high){
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
    }
}