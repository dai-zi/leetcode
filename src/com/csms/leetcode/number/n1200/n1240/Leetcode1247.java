package com.csms.leetcode.number.n1200.n1240;
//交换字符使得字符串相同
//中等
public class Leetcode1247 {
public int minimumSwap(String s1, String s2) {
    int len = s1.length(), xy = 0, yx = 0;
    char[] cs1 = s1.toCharArray();
    char[] cs2 = s2.toCharArray();
    for(int i = 0; i < len; i ++) {
        if(cs1[i] == cs2[i]) {
            continue;
        }
        else if(cs1[i] == 120) {
            xy ++;
        }
        else {
            yx ++;
        }
    }
    return ((xy + yx) & 1) == 1 ? -1 : (xy + 1) / 2 + (yx + 1) / 2;
}

    public static void main(String[] args) {
    }
}