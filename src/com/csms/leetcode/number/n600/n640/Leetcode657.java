package com.csms.leetcode.number.n600.n640;
//机器人能否返回原点
//简单
public class Leetcode657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
    public static void main(String[] args) {
    }
}