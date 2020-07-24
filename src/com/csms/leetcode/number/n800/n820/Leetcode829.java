package com.csms.leetcode.number.n800.n820;
//连续整数求和
//困难
public class Leetcode829 {
    public int consecutiveNumbersSum(int N) {
        // 2N = k(2x + k + 1)
        int ans = 0;
        for (int k = 1; k <= 2*N; ++k)
            if (2 * N % k == 0) {
                int y = 2 * N / k - k - 1;
                if (y % 2 == 0 && y >= 0)
                    ans++;
            }
        return ans;
    }
    public static void main(String[] args) {
    }
}