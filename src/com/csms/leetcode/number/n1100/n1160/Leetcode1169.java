package com.csms.leetcode.number.n1100.n1160;

import java.util.ArrayList;
import java.util.List;

//查询无效交易
//中等
public class Leetcode1169 {
public List<String> invalidTransactions(String[] transactions) {
        Transaction[] trans = new Transaction[transactions.length];
        int index = 0;
        for(String tran : transactions){
            String[] strings = tran.split(",");
            trans[index++] = new Transaction(strings[0],Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),strings[3]);
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<trans.length;i++){
            if(trans[i].money>1000)list.add(transactions[i]);
            else{
                for(int j=0;j<trans.length;j++){
                    if(i!=j && trans[j].name.equals(trans[i].name) && !trans[j].city.equals(trans[i].city)
                            && Math.abs(trans[j].time - trans[i].time)<=60){
                        list.add(transactions[i]);
                        break;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
    }
}
class Transaction{
    String name;
    Integer time;
    Integer money;
    String city;

    public Transaction(String name, Integer time, Integer money, String city) {
        this.name = name;
        this.time = time;
        this.money = money;
        this.city = city;
    }
}
