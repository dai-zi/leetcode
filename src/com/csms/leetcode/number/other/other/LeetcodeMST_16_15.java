package com.csms.leetcode.number.other.other;
//珠玑妙算
//简单
public class LeetcodeMST_16_15 {
private int[] s_arr = new int[4], g_arr = new int[4];

    public int[] masterMind(String solution, String guess) {
        int real = 0, fake = 0;
        for (int i = 0; i < 4; ++i) {
            if (solution.charAt(i) == guess.charAt(i))
                ++real;
            else {
                count(s_arr, solution.charAt(i));
                count(g_arr, guess.charAt(i));
            }
        }
        for (int i = 0; i < 4; ++i)
            fake += Math.min(s_arr[i], g_arr[i]);
        return new int[]{real, fake};
    }

    private void count(int[] arr, char ch) {
        switch (ch) {
            case 'R':
                ++arr[0];
                break;
            case 'Y':
                ++arr[1];
                break;
            case 'G':
                ++arr[2];
                break;
            default:
                ++arr[3];
        }
    }
    public static void main(String[] args) {
    }
}