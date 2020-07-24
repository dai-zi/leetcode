package com.csms.leetcode.number.n1300.n1380;

import java.util.HashMap;
import java.util.Map;

//设计地铁系统
//中等
public class Leetcode1396 {
private Map<String, Integer> time;
    private Map<String, Integer> count;
    private Map<Integer, Integer> idToTime;
    private Map<Integer, String> idToStation;
    public Leetcode1396() {
        time = new HashMap<>();
        count = new HashMap<>();
        idToTime = new HashMap<>();
        idToStation = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToTime.put(id, t);
        idToStation.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int startTime = idToTime.get(id);
        String startStation = idToStation.get(id);
        String stationInfo = startStation + stationName;
        time.put(stationInfo, time.getOrDefault(stationInfo, 0) + t - startTime);
        count.put(stationInfo, count.getOrDefault(stationInfo, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationInfo = startStation + endStation;
        return time.get(stationInfo) * 1.0 / count.get(stationInfo);
    }
    public static void main(String[] args) {
    }
}