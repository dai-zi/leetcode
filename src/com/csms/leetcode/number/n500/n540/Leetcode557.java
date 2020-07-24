package com.csms.leetcode.number.n500.n540;
//反转字符串中的单词III
//简单
public class Leetcode557 {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    public static void main(String[] args) {
    }
}