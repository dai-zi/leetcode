package com.csms.leetcode.number.n300.n380;

import java.util.HashMap;

//字符串中的第一个唯一字符
//简单
public class Leetcode387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int[] count = new int[26];//计数

        //将字符串转化为数组再遍历，也可使用charAt遍历
        //使用c-'a'将字母转化为0~25
        char[] array = s.toCharArray();
        for (char c : array)
            count[c - 'a']++;

        //再次遍历array，只要找到出现次数为1的字符，立即返回索引
        for (int i = 0; i < s.length(); i++)
            if (count[array[i] - 'a'] == 1)
                return i;

        //如果找不到返回-1
        return -1;
    }
    public static void main(String[] args) {
    }
}