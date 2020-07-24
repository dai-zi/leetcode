package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.List;

//T9键盘
//中等
public class LeetcodeMST_16_20 {
public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        char[] map = {'2','2','2','3','3','3','4','4','4','5','5','5','6','6','6','7','7','7','7','8','8','8','9','9','9','9'};
        for (String word : words) {
            int index = 0;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                char n = map[c - 'a'];
                if (n != num.charAt(index ++)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}