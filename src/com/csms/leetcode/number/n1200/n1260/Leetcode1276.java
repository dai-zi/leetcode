package com.csms.leetcode.number.n1200.n1260;

import java.util.ArrayList;
import java.util.List;

//不浪费原料的汉堡制作方案
//中等
public class Leetcode1276 {
public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        if(tomatoSlices%2 !=0 || cheeseSlices>tomatoSlices || (tomatoSlices/2)<cheeseSlices){
            return list;
        }
        //全职做小皇堡所剩的材料
        int flat = tomatoSlices-(cheeseSlices*2);
        if(flat ==0){
            list.add(0);
            list.add(cheeseSlices);
            return list;
        }

        if((flat/2)<=cheeseSlices){
            list.add((flat/2));
            list.add(cheeseSlices-(flat/2));
            return list;
        }
        return list;
    }

    public static void main(String[] args) {
    }
}