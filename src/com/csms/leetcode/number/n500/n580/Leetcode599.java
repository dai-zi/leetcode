package com.csms.leetcode.number.n500.n580;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//两个列表的最小索引总和
//简单
public class Leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap< String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List< String > res = new ArrayList< >();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
    }
}