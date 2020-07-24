package com.csms.leetcode.number.n800.n880;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//两句话中的不常见单词
//简单
public class Leetcode884 {
public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
    public static void main(String[] args) {
    }
}