package com.csms.leetcode.number.n1000.n1040;

import java.util.*;

//最长字符串链
//中等
public class Leetcode1048 {
private int Max = 1;
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        int  minlen = words[0].length();
        int maxlen = minlen;
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            minlen = Math.min(minlen, len);
            maxlen = Math.max(maxlen, len);
            Set<String> set = map.get(len);
            if (set == null) {
                set = new HashSet<>();
                map.put(len, set);
            }
            set.add(word);
        }

        for (int len = minlen; len <= maxlen; len++) {
             Set<String> oneSet = map.get(len);
             if (oneSet == null) break;
             if (maxlen + 1 - len <= Max) break;
             
             for (String a: oneSet) {
                 findNext(map, len, a);
             }
        }

        return Max;
    }

    private void findNext(Map<Integer, Set<String>> map, int start, String base) {
        Max = Math.max(Max, (base.length() + 1) - start);
        Set<String> set = map.get(base.length() + 1);
        if (set == null) {
            return;
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String one = iterator.next();
            if (match(base, one)) {
                findNext(map, start, one);
                iterator.remove();
            }
        }
    }

    private boolean match(String base, String next) {
        int i = 0;
        int len = base.length();
        while (i < len && next.charAt(i) == base.charAt(i)) {
            i++;
        }
        
        if (i == len) return true;

        while (i < len && next.charAt(i + 1) == base.charAt(i)) {
            i++;
        }
        
        return i == len;
    }

    public static void main(String[] args) {
    }
}