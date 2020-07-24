package com.csms.leetcode.number.n100.n100;

import java.util.ArrayList;
import java.util.List;

//杨辉三角II
//简单
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            res.add(1);
            for(int j = i - 1; j > 0; j--){
                res.set(j, (res.get(j) + res.get(j - 1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}