package com.csms.leetcode.number.n1200.n1280;

import java.util.Arrays;
import java.util.List;

//字母组合迭代器
//中等
public class Leetcode1286 {
 String characters;
        int now = 0;
        List<int[]> comb;
        public Leetcode1286(String characters, int combinationLength) {
            generate(new int[combinationLength], 0,0, characters.length());
            this.characters = characters;
        }
        public String next() {
            int[] pos = comb.get(now);
            StringBuilder sb = new StringBuilder();
            for (int po : pos) {
                sb.append(characters.charAt(po));
            }
            now++;
            return sb.toString();
        }

        public boolean hasNext() {
            return now< comb.size();
        }


        public void generate(int[] pos, int p, int s, int len) {
            if(p>=pos.length){
                comb.add(Arrays.copyOf(pos, pos.length));
                return;
            }
            for(int i = s; i<len;i++){
                pos[p] = i;
                generate(pos,  p+1,i+1, len);
            }
        }

    public static void main(String[] args) {
    }
}