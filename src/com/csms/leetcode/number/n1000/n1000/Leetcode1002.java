package com.csms.leetcode.number.n1000.n1000;

import java.util.LinkedList;
import java.util.List;

//查找常用字符
//简单
public class Leetcode1002 {
public List<String> commonChars(String[] A) {
        int[] hash = new int[26];
        int[] temp = new int[26];
        for(int i = 0; i < 26; i++)
            hash[i] = 100;//每个字符出现次数最多100次，因为题目有限制每个单词最多含有100字符
        for(int i = 0; i < A.length; i++)
        {
            for(char c : A[i].toCharArray())
                temp[c - 'a']++;
            for(int j = 0; j < 26; j++)
            {
                hash[j] = Math.min(hash[j], temp[j]);
                temp[j] = 0;
            }
        }
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < 26; i++)
        {
            while(hash[i] > 0)
            {
                list.add(String.valueOf((char)(i + 'a')));
                hash[i]--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
    }
}