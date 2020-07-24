package com.csms.leetcode.number.n1000.n1080;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//不同字符的最小子序列
//中等
public class Leetcode1081 {
public String smallestSubsequence(String text) {
        if (text == null || text.length() == 1) return text;
        int len = text.length();
        int[] recordCharCount = new int[26]; // 用来保存字母出现的次数

        Stack<Character> res = new Stack<>();
        for (int i = 0; i < len; i++){
            recordCharCount[text.charAt(i) - 'a'] += 1;
        }

        Map<Character, Integer> hasMap = new HashMap<>(); // 用来记录栈中是否存在当前遍历的字符
        for (int i = 0; i < len; i++){
            recordCharCount[text.charAt(i) - 'a'] -= 1;
            if (hasMap.containsKey(text.charAt(i))) {
                continue;
            }
            while (!res.isEmpty()){
                char curPeekChar = res.peek();
                if (curPeekChar > text.charAt(i) && recordCharCount[curPeekChar - 'a'] > 0){
                    res.pop();
                    hasMap.remove(curPeekChar);
                }else{
                    break;
                }
            }
            res.push(text.charAt(i));
            hasMap.put(text.charAt(i), 1);
        }

        StringBuffer result = new StringBuffer();
        while (!res.isEmpty()){
            result.append(res.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
    }
}