package com.csms.leetcode.number.n1000.n1040;

import java.util.HashSet;

//删除字符串中的所有相邻重复项
//简单
public class Leetcode1047 {
public String removeDuplicates(String S) {
      // generate 26 possible duplicates
        HashSet<String> duplicates = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; ++i) {
            sb.setLength(0);
            sb.append(i); sb.append(i);
            duplicates.add(sb.toString());
        }

        int prevLength = -1;
        while (prevLength != S.length()) {
            prevLength = S.length();
            for (String d : duplicates) S = S.replace(d, "");
        }

      return S;
    }
    public static void main(String[] args) {
    }
}