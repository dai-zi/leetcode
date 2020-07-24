package com.csms.leetcode.number.other.other;
//配对交换
//简单
public class LeetcodeMST_05_07 {
public int exchangeBits(int num) {
        int ans = 0, count = 0;
        while (num > 0) {
            int last = (num & 1); //取得num的最后一位
            num >>= 1;
            if (count % 2 == 0)
                last <<= 1 * (count + 1); 
            else 
                last <<= 1 * (count - 1);
            ans |= last;
            count++;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}