package com.csms.leetcode.number.n1000.n1060;

import java.util.LinkedList;
import java.util.List;

//Bigram分词
//简单
public class Leetcode1078 {
public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new LinkedList<>();
        for(int i = 0;i < words.length - 2;i++){
            if(words[i].equals(first) && words[i + 1].equals(second)){
                res.add(words[i + 2]);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
    }
}