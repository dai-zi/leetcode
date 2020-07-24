package com.csms.leetcode.number.other.other;
//剧情触发时间
//中等
public class LeetcodeLCP08 {
public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] result = new int[requirements.length];

        //1. 累加属性值，形成一个玩家每天属性值的数组
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }

        //2. 遍历触发条件，得到每个触发条件对应的天数
        for (int i = 0; i < requirements.length; i++) {
            //2.1 特殊情况处理：如果触发条件对应的属性值为0，则触发天数也是0
            if (requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0) {
                result[i] = 0;
            } else {
                //2.2 本题的核心思想，使用二分查找算法来寻找左侧边界，找到触发剧情最小的天数。
                int left = 0;
                int right = increase.length - 1;

                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if (increase[middle][0] < requirements[i][0] || increase[middle][1] < requirements[i][1] || increase[middle][2] < requirements[i][2]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
                if (left < increase.length && increase[left][0] >= requirements[i][0] && increase[left][1] >= requirements[i][1] && increase[left][2] >= requirements[i][2]) {
                    result[i] = left + 1;
                } else {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}