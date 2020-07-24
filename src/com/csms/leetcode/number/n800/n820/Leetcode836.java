package com.csms.leetcode.number.n800.n820;
//矩形重叠
//简单
public class Leetcode836 {
 public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }

    public static void main(String[] args) {
    }
}