package com.csms.leetcode.number.n1300.n1380;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//安排电影院座位
//中等
public class Leetcode1386 {
private boolean isOk(int l, int r, Set<Integer> colSet) {
        for (int i = l; i <= r; i++) {
            if (colSet.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) {
            Set<Integer> colSet = map.get(row);
            int count = 0;
            if (isOk(2, 5, colSet)) {
                count++;
                if (isOk(6, 9, colSet)) {
                    count++;
                }
            } else {
                if (isOk(4, 7, colSet)) {
                    count++;
                } else {
                    if (isOk(6, 9, colSet)) {
                        count++;
                    }
                }
            }

            int diff = 2 - count;
            ans -= diff;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}