package com.csms.leetcode.number.other.other;
//猜数字
//简单
public class LeetcodeLCP01 {
public int game(int[] guess, int[] answer) {
        int count = 0;
        //对应位置比较，相等则猜对
        for(int i = 0; i < guess.length; i++){
            if(guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}