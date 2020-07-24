package com.csms.leetcode.number.n400.n440;

import java.util.HashMap;
import java.util.Map;

//回旋镖的数量
//简单
public class Leetcode447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        // i 遍历二维数组第一列
        for (int i = 0; i < points.length; i++) {
            // map 中存储点 i 到所有其他点的距离出现的频次
            Map<Integer,Integer> map = new HashMap<>();
            // j 遍历二维数组第二列
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算距离时不进行开根运算, 以保证精度（反正距离相等）
                    int dis = dis(points[i], points[j] );
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            // 排列组合，例如：三个数选两个并且可以改变顺序，也就是A32 = 3 * 2
            for (int dis : map.keySet() ) {
                ans += (map.get(dis) ) * (map.get(dis) - 1);
            }
        }
        return ans;
    }

    // 计算距离（平方和）
    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
    public static void main(String[] args) {
    }
}