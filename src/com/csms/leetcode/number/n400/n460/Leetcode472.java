package com.csms.leetcode.number.n400.n460;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//连接词
//困难
public class Leetcode472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (!word.equals("")) {  // 题目描述有问题, 应该补充上连接词至少由两个非空单词组成, 否则如果 words 包含空串, 那么 words 中的其它所有字符串都是连接词. 这里加上特判就可以了.
                root.add(word);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (dfs(word.toCharArray(), 0, root)) {
                res.add(word);
            }
        }
        return res;
    }
    private boolean dfs(char[] str, int start, TrieNode root) {
        int n = str.length;
        TrieNode node = root;
        for (int i = start; i < n; i++) {
            if (!node.next.containsKey(str[i])) {
                return false;
            }
            node = node.next.get(str[i]);
            // 短路运算: 如果找到了一个字符串则尝试从头开始走, 找下一个字符串
            if (node.isWord && dfs(str, i + 1, root)) {
                return true;
            }
        }
        return node.isWord && start != 0;  // start != 0 含义即是不能匹配到自己
    }
class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> next;
    public TrieNode() {
        isWord = false;
        next = new HashMap<>();
    }
    public void add(String str) {
        TrieNode node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
        }
        node.isWord = true;
    }
}


    public static void main(String[] args) {
    }
}