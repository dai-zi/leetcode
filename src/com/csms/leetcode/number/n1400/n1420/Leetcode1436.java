package com.csms.leetcode.number.n1400.n1420;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//旅行终点站
//简单
public class Leetcode1436 {
public String destCity(List<List<String>> paths) {
        Map<String, String> map = prepare(paths);
        String from = paths.get(0).get(0);
        while(true){
            if(!map.containsKey(from))
                return from;
            from = map.get(from);
        }
    }

    private Map<String, String> prepare(List<List<String>> paths){
        Map<String, String> map = new HashMap<>();
        for(List<String> path : paths)
            map.put(path.get(0), path.get(1));
        return map;
    }
    public static void main(String[] args) {
    }
}