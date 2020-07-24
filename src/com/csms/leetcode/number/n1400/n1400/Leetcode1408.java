package com.csms.leetcode.number.n1400.n1400;

import java.util.ArrayList;
import java.util.List;

//数组中的字符串匹配
//简单
public class Leetcode1408 {
public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        if (words.length == 0) return list;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            String str = words[i];
            builder.append(str + ",");
        }

        for (int i = 0; i < words.length; i++){
            String str = words[i];
            if (builder.toString().indexOf(str) != builder.toString().lastIndexOf(str)) list.add(str);
        }
        return list;
    }
    public static void main(String[] args) {
    }
}