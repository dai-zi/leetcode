package com.csms.leetcode.number.n400.n480;
//神奇字符串
//中等
public class Leetcode481 {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;
        boolean isOne = true;
        int count = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            len += arr[i];
            if (arr[i] == 1) {
                if (isOne) {
                    arr[len - 1] = 1;
                } else {
                    arr[len - 1] = 2;
                }
            } else {
                if (isOne) {
                    arr[len - 1] = arr[len - 2] = 1;
                } else {
                    arr[len - 1] = arr[len - 2] = 2;
                }

            }
            if (isOne) {
                count += arr[i];
            }
            if (len >= n) {
                break;
            }
            isOne = !isOne;
        }

        return len > n && isOne ? count - 1 : count;
    }
    public static void main(String[] args) {
    }
}