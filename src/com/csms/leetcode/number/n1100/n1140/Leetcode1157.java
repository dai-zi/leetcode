package com.csms.leetcode.number.n1100.n1140;

import java.util.*;

//子数组中占绝大多数的元素
//困难
public class Leetcode1157 {
    int[] nums;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer>[] lists = new ArrayList[20001];
    List<ArrayList<Integer>> counter = new ArrayList<>();
    int[] temp;

    public Leetcode1157(int[] arr) {
        nums = arr;

        for (int i = 0; i < arr.length; i++) {
            if (lists[nums[i]] == null) {
                lists[nums[i]] = new ArrayList<>();
                lists[nums[i]].add(-1 * nums[i]);
                counter.add(lists[nums[i]]);
            }
            lists[nums[i]].add(i);

        }
        counter.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        temp = new int[counter.size()];
        for (int i = 0; i < counter.size(); i++) {
            temp[i] = counter.get(i).size();
        }

    }

    public int query(int left, int right, int threshold) {

        if (right - left <=50) {

            map.clear();

            for (int i = left; i <= right; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) >= threshold) {
                    return nums[i];
                }
            }
            return -1;
        } else {
            int len = right - left + 1;
            int pos = Arrays.binarySearch(temp, threshold - 1);
            if (pos < 0) {
                pos = -1 * pos - 1;
            }

            for (int i = pos; i < counter.size(); i++) {
                int s = Collections.binarySearch(counter.get(i), left);
                if (s < 0) {
                    s = -1 * s - 1;
                }
                int e = Collections.binarySearch(counter.get(i), right);
                if (e < 0) {
                    e= -1 * e - 2;
                }
                if (e - s + 1 >= threshold) {
                    return counter.get(i).get(0) * -1;
                }
            }
            return -1;
        }

    }
    public static void main(String[] args) {
    }
}