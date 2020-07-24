package com.csms.leetcode.number.n200.n200;

import com.csms.leetcode.common.TrieNode;
import com.csms.leetcode.number.n1200.n1260.Leetcode1268;

//实现Trie(前缀树)
//中等
public class Leetcode208 {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public Leetcode208() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public static void main(String[] args) {
    }
}
