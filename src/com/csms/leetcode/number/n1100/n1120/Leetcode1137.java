package com.csms.leetcode.number.n1100.n1120;
//第N个泰波那契数
//简单
public class Leetcode1137 {
public int tribonacci(int n) {
    if (n < 3) return n == 0 ? 0 : 1;

    int tmp, x = 0, y = 1, z = 1;
    for (int i = 3; i <= n; ++i) {
      tmp = x + y + z;
      x = y;
      y = z;
      z = tmp;
    }
    return z;
  }
    public static void main(String[] args) {
    }
}