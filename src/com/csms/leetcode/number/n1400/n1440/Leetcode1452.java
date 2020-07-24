package com.csms.leetcode.number.n1400.n1440;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//收藏清单
//中等
public class Leetcode1452 {
public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Integer> result = new ArrayList<>();
    int n = favoriteCompanies.size();
    for (int i = 0; i < n; i++) {
        boolean flag = true;
        for (int j = 0; j < n; j++) {
            if (i == j) {
                continue;
            }
            List<String> companies1 = favoriteCompanies.get(i);
            List<String> companies2 = favoriteCompanies.get(j);
            Set<String> set = new HashSet<>(companies2);
            if (set.containsAll(companies1)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            result.add(i);
        }
    }
    return result;
}

    public static void main(String[] args) {
    }
}