package com.csms.leetcode.number.n1400.n1400;

import java.util.*;

//点菜展示表
//中等
public class Leetcode1418 {
public static List<List<String>> displayTable(List<List<String>> orders) {
        //tableId -> {foodName -> foodCount}
        TreeMap<String, Map<String, Integer>> tableFoodMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        
        Set<String> foodNameSet = new HashSet<>();

        //遍历所有订单，放入tableFoodMap结构中
        for (List<String> order :orders) {
            String tableId = order.get(1);
            String foodName = order.get(2);

            foodNameSet.add(foodName);

            if (tableFoodMap.containsKey(tableId)) {
                Map<String, Integer> foodCountMap = tableFoodMap.get(tableId);
                foodCountMap.put(foodName, foodCountMap.getOrDefault(foodName, 0) + 1);
            } else {
                Map<String, Integer> foodCountMap = new HashMap<>();
                foodCountMap.put(foodName, 1);
                tableFoodMap.put(tableId, foodCountMap);
            }
        }

        //菜品名称按照字母序排序
        List<String> orderedFoodNames = new ArrayList<>(foodNameSet);
        orderedFoodNames.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<List<String>> showMenus = new ArrayList<>();
        //构造每桌每个菜品数量
        for (Map.Entry<String, Map<String, Integer>> entry : tableFoodMap.entrySet()) {
            String tableId = entry.getKey();
            List<String> showMenu = new ArrayList<>();
            showMenu.add(tableId);
            for (String foodName : orderedFoodNames) {
                showMenu.add(entry.getValue().getOrDefault(foodName, 0) + "");
            }
            showMenus.add(showMenu);
        }
        //构造标题
        orderedFoodNames.add(0, "Table");
        List<List<String>> res = new ArrayList<>();
        res.add(orderedFoodNames);
        res.addAll(showMenus);


        return res;
    }
    public static void main(String[] args) {
    }
}