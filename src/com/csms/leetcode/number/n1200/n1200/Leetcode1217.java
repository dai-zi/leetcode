package com.csms.leetcode.number.n1200.n1200;
//玩筹码
//简单
public class Leetcode1217 {
public int minCostToMoveChips(int[] chips) {
        int odd = 0,even = 0;
        for(int data : chips)
            if(data % 2 == 1)
                odd++;
            else
                even++;
        
        return Math.min(odd,even);
    }

    public static void main(String[] args) {
    }
}