package com.csms.leetcode.number.n400.n400;

import java.util.ArrayList;
import java.util.List;

//二进制手表
//简单
public class Leetcode401 {
    public List<String> readBinaryWatch(int num) {
        List<List<Integer>> tmp = new ArrayList<>();
        search(0, num, new ArrayList<>(), tmp);

        List<String> res = new ArrayList<>();
        for (List<Integer> list : tmp) {
            int hour = 0;
            int minute = 0;
            for (int n : list) {
                if (n <= 3) {
                    hour += 1 << n;
                } else {
                    minute += 1 << (n - 4);
                }
            }

            if (hour > 11 || minute > 59) {
                continue;
            }

            String m = minute < 10 ? "0" + minute : "" + minute;
            res.add(hour + ":" + m);
        }

        return res;
    }

    // 将小时和分钟依次从0到3，4到9编号，从start到9中选num个数，将结果放入tmp中
    private void search(int start, int num, List<Integer> curList, List<List<Integer>> tmp) {
        if (num == 0) {
            tmp.add(new ArrayList<>(curList));
            return;
        }

        for (int i = start; i <= 9; i++) {
            curList.add(i);
            search(i + 1, num - 1, curList, tmp);
            curList.remove(curList.size() - 1);
        }
    }
    public static void main(String[] args) {
    }
}