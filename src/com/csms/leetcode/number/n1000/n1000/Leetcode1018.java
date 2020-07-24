package com.csms.leetcode.number.n1000.n1000;

import java.util.ArrayList;
import java.util.List;

//可被5整除的二进制前缀
//简单
public class Leetcode1018 {
public List<Boolean> prefixesDivBy5(int[] A) {
        int num=0;
        List<Boolean> ans=new ArrayList<>();
        for(int index=0;index<A.length;index++){
            num=(num*2+A[index])%5;
            if(num==0)ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}