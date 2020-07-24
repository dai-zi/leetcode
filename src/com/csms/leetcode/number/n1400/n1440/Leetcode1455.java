package com.csms.leetcode.number.n1400.n1440;
//检查单词是否为句中其他单词的前缀
//简单
public class Leetcode1455 {
public int isPrefixOfWord(String sentence, String searchWord) {
    String[] senArr = sentence.split(" ");
    for (int i = 0 ; i < senArr.length; i++) {
        if (senArr[i].indexOf(searchWord) == 0) return i + 1;
    }
    return -1;
}
    public static void main(String[] args) {
    }
}