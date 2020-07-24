package com.csms.leetcode.number.n900.n940;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//按递增顺序显示卡牌
//中等
public class Leetcode950 {
public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}