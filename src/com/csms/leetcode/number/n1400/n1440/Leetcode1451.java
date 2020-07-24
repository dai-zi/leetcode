package com.csms.leetcode.number.n1400.n1440;

import java.util.Arrays;

//重新排列句子中的单词
//中等
public class Leetcode1451 {
public String arrangeWords(String text) {
           String[] s = text.toLowerCase().split(" ");


        Arrays.sort(s, (o1, o2) -> {

                return o1.length()-o2.length();
        });
        

        char first=s[0].charAt(0);
        first=(char)(first-32);
        String temp= first +s[0].substring(1);
        s[0]=temp;
        String res="";
        res= String.join(" ", s);

        return res;
       
    
    }

    public static void main(String[] args) {
    }
}