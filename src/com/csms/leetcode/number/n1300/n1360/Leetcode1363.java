package com.csms.leetcode.number.n1300.n1360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//形成三的最大倍数
//困难
public class Leetcode1363 {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        List<Integer> rem1Indexs = new ArrayList<>();
        List<Integer> rem2Indexs = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum += digits[i];
            if(digits[i] % 3 == 1){
                rem1Indexs.add(i);
            } else if(digits[i] % 3 == 2){
                rem2Indexs.add(i);
            }
        }
        sum %= 3;
        if(sum == 1){
            if(!rem1Indexs.isEmpty()){
                return constructRes(digits, rem1Indexs.get(0), -1);
            } else {
                return constructRes(digits, rem2Indexs.get(0), rem2Indexs.get(1));
            }
        } else if(sum == 2){
            if(!rem2Indexs.isEmpty()){
                return constructRes(digits, rem2Indexs.get(0), -1);
            } else {
                return constructRes(digits, rem1Indexs.get(0), rem1Indexs.get(1));
            }
        }
        return constructRes(digits, -1, -1);
    }

    private String constructRes(int[] digits, int ignoreId1, int ignoreId2){
        StringBuilder res = new StringBuilder();
        for(int i = digits.length -1; i >= 0; i--){
            if(i == ignoreId1 || i == ignoreId2){
                continue;
            }
            res.append(digits[i]);
        }
        return res.length() > 0 && res.charAt(0) == '0' ? "0": res.toString();
    }
    public static void main(String[] args) {
    }
}