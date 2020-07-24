package com.csms.leetcode.number.n1400.n1440;

import java.util.ArrayList;
import java.util.List;

//最简分数
//中等
public class Leetcode1447 {
public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if(n==1) return list;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(j!=1&&i%j==0||judge(i,j)) continue;
                String str = j+"/"+i;
                list.add(str);
            }
        }
        return list;
    }
    public boolean judge(int a,int b){
        int res = a%b;
        while(res!=0){
            a = b;
            b = res;
            res = a%b;
        }
        return b==1?false:true;
    }

    public static void main(String[] args) {
    }
}