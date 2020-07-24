package com.csms.leetcode.number.n700.n760;
//宝石与石头
//简单
public class Leetcode771 {
public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s: S.toCharArray()) // For each stone...
            for (char j: J.toCharArray()) // For each jewel...
                if (j == s) {  // If the stone is a jewel...
                    ans++;
                    break; // Stop searching whether this stone 's' is a jewel
                }
        return ans;
    }
    public static void main(String[] args) {
    }
}