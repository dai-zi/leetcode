package com.csms.leetcode.number.n1200.n1260;
//访问所有点的最小时间
//简单
public class Leetcode1266 {
public int minTimeToVisitAllPoints(int[][] points) {

int result = 0;
		int[] currPoint = points[0];
		for (int[] point : points) {
			int currX = currPoint[0], currY = currPoint[1];
			int nextX = point[0], nextY = point[1];
			while (currX != nextX || currY != nextY) {
				if (currX > nextX) {
					currX--;
				}
				if (currX < nextX) {
					currX++;
				}
				if (currY > nextY) {
					currY--;
				}
				if (currY < nextY) {
					currY++;
				}
				result++;
			}
			currPoint = point;
		}
		return result;
    }
    public static void main(String[] args) {
    }
}