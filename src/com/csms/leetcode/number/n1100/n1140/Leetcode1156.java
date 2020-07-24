package com.csms.leetcode.number.n1100.n1140;
//单字符重复子串的最大长度
//中等
public class Leetcode1156 {
public int maxRepOpt1(String text) {
        int len = text.length();
        int[] ch_count = new int[26];
        //统计26个小写字母各自出现的次数
        for (int i = 0; i < len; ++i)
            ++ch_count[text.charAt(i) - 'a'];
        char last_ch = text.charAt(0);
        int count = 1, res = 1;
        for (int i = 1; i < len; ++i) {
            if (last_ch != text.charAt(i)) {
                int temp_idx = i;
                while (temp_idx + 1 < len && last_ch == text.charAt(temp_idx + 1)) {
                    ++count;
                    ++temp_idx;
                }
                if (ch_count[last_ch - 'a'] > count)
                    ++count;
                res = Math.max(res, count);
                count = 1;
                last_ch = text.charAt(i);
            } else
                ++count;
        }
        if (count > 1 && ch_count[last_ch - 'a'] > count)
            ++count;
        return Math.max(res, count);
    }

    public static void main(String[] args) {
    }
}