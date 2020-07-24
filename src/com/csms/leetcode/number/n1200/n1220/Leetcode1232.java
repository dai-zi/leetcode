package com.csms.leetcode.number.n1200.n1220;
//缀点成线
//简单
public class Leetcode1232 {
public boolean checkStraightLine(int[][] coordinates) {
         int x1 =coordinates[1][0]-coordinates[0][0];
        int y1 =coordinates[1][1]-coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x2 =coordinates[i][0]-coordinates[0][0];
            int y2 =coordinates[i][1]-coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}