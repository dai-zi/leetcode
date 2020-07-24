package com.csms.leetcode.number.n1300.n1360;
//上升下降字符串
//简单
public class Leetcode1370 {
public String sortString(String s) {
        int[] arr = new int[26];// 序号+97是字母，数值是剩余个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 97]++;
        }
        // 统计完了所有的字符
        int left = s.length();
        StringBuffer sb = new StringBuffer();
        while (left > 0) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    char c = (char) (i + 97);
                    sb.append(c);
                    arr[i]--;
                    left--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] != 0) {
                    char c = (char) (i + 97);
                    sb.append(c);
                    arr[i]--;
                    left--;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    }
}