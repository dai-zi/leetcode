package com.csms.leetcode.number.n1100.n1100;
//有效括号的嵌套深度
//中等
public class Leetcode1111 {
public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}