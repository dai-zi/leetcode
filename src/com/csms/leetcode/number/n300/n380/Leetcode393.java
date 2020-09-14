package com.csms.leetcode.number.n300.n380;

import java.util.Comparator;
import java.util.PriorityQueue;

//UTF_8编码验证
//中等
public class Leetcode393 {
    static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int d = o1[0] - o2[0];
            return d == 0 ? o1[1] - o2[1] : d;
        }
    };
    static Comparator<int[]> compByRight = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int d = o1[2] - o2[2];
            return d == 0 ? o1[1] - o2[1] : d;
        }
    };
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) {
            return true;
        }
        // 构造两个堆，快速取出最小值
        PriorityQueue<int[]> allHeap = new PriorityQueue<>(rectangles.length, comp);
        PriorityQueue<int[]> matchHead = new PriorityQueue<>(rectangles.length, compByRight);

        for (int i = 0; i < rectangles.length; i++) {
            allHeap.add(rectangles[i]);
        }

        // 检查和初始化最左下角的所有矩形
        int[] last = allHeap.poll();
        matchHead.add(last);
        while (!allHeap.isEmpty()) {
            int[] head = allHeap.peek();
            if (head[0] != last[0]) {
                break;
            }
            allHeap.poll();
            if (head[1] != last[3]) {
                return false;
            }
            matchHead.add(head);
            last = head;
        }

        // 每次循环取出当前需要匹配的那个矩形，与allMap中的唯一候选矩形进行匹配并更新matchHead
        int[] head = matchHead.poll();
        while (!allHeap.isEmpty()) {
            int[] cur = allHeap.poll();
            int lastyl = cur[1];
            while (true) {
                if (cur[0] == head[2] && lastyl == head[1]) {
                    if (cur[3] > head[3]) {
                        lastyl = head[3];
                        if (matchHead.isEmpty()) {
                            return false;
                        }
                        head = matchHead.poll();
                        continue;
                    }
                    matchHead.add(cur);
                    if (cur[3] == head[3]) {
                        head = matchHead.poll();
                    } else {
                        head[1] = cur[3];
                    }
                    break;
                } else {
                    return false;
                }
            }
        }
        // 循环结束后, 检查matchHead中的所有矩形是否叠加
        while (!matchHead.isEmpty()) {
            int[] e = matchHead.poll();
            if (head[2] != e[2] || head[3] != e[1]) {
                return false;
            }
            head = e;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}