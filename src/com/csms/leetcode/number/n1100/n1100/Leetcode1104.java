package com.csms.leetcode.number.n1100.n1100;

import java.util.ArrayList;
import java.util.List;

//二叉树寻路
//中等
public class Leetcode1104 {
public List<Integer> pathInZigZagTree(int label) {
        List<Integer>res=new ArrayList<>();
        res.add(1);
        if (label==1)
            return res;
        
        int last=(int)Math.floor(Math.log(label)/Math.log(2));
        
        if ((last&1)==1) {
            int rightLen=(1<<last+1)-label-1;
            label =(1<<last)+rightLen;
        }
        
        while (label!=1){
            res.add(1,label);
            label=label>>1;
        }
        
        for (int i=0;i<res.size();i++){
            if ((i&1)==1){
                int rightLen=(1<<i+1)-res.get(i)-1;
                res.set(i,(1<<i)+rightLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}