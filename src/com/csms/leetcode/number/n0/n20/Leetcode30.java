package com.csms.leetcode.number.n0.n20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//串联所有单词的子串
//困难
public class Leetcode30 {
    //baoli
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (words==null||words.length==0)return res;
        //单词个数、单词长度
        int wordNum = words.length,wordLen=words[0].length();
        //将words每个单词及其个数存入hashmap
        HashMap<String,Integer> allWords=new HashMap<>();
        for (String word : words) {
            Integer value = allWords.getOrDefault(word, 0);
            allWords.put(word,++value);
        }
        //遍历s每一个子串,剩余不足wordNum*wordLen个字符的子串不需要遍历
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //将子串中出现的和words中相等的单词及其出现次数存入hashmap
            HashMap<String,Integer> hasWords=new HashMap<>();
            //记录字串中和words中相等单词数量
            int count=0;
            //统计字串中连续和words中相等的单词
            while (count<wordNum){
                String word = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                //如果word匹配words中的单词，就统计其出现次数
                if (allWords.containsKey(word)){
                    Integer value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word,++value);
                    //如果word出现次数超过words中这个单词的总数量则结束统计
                    if (hasWords.get(word)>allWords.get(word))break;
                }else {
                    //如果字串中出现于words中所有单词都不匹配的word则结束统计
                    break;
                }
                //增加成功与words中匹配的单词数量
                count++;
            }
            if (count==wordNum)res.add(i);
        }
        return res;
    }
    //huadongchuangkou
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if (s==null||words==null||words.length==0)return result;
        int wordsNum = words.length,wordLen=words[0].length();
        //将words中的单词及其数量存入hashmap
        HashMap<String,Integer> allWords=new HashMap<>();
        for (String word : words) {
            Integer value = allWords.getOrDefault(word, 0);
            allWords.put(word,value+1);
        }
        //分成wordLen中情况，分别从0开始每次移动一个单词长度~从wordLen-1开始每次移动一个单词长度
        for (int j=0;j<wordLen;j++){
            //haswords存放当前子串中匹配的单词及其个数，count当前子串匹配的单词数量
            HashMap<String,Integer> haswords=new HashMap<>();
            int count=0;
            //遍历从j开始的每个子串，每次动一个单词长度
            for (int i=j;i<s.length()-wordLen*wordsNum+1;i+=wordLen){
                //防止情况三出现之后，情况一继续移除
                boolean hasRemoved=false;
                while (count<wordsNum){
                    String curWord = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                    //当前单词匹配，加入haswords
                    if (allWords.containsKey(curWord)) {
                        Integer value = haswords.getOrDefault(curWord, 0);
                        haswords.put(curWord,value+1);
                        count++;
                        //情况三，当前单词匹配，但是数量超了
                        if (haswords.get(curWord) > allWords.get(curWord)) {
                            hasRemoved=true;
                            //从i开始逐个单词，从haswords中移除，removeNum记录移除的单词个数
                            int removeNum=0;
                            while (haswords.get(curWord) > allWords.get(curWord)) {
                                String fristWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                Integer v = haswords.get(fristWord);
                                haswords.put(fristWord,v-1);
                                removeNum++;
                            }
                            //移除完毕之后，更新count
                            count-=removeNum;
                            //移动i的位置(注意removeNum要-1，因为跳出当前循环之后，i还要+wordLen)
                            i+=(removeNum-1)*wordLen;
                            break;
                        }
                    }else{//情况二，当前单词不匹配
                        //清空haswords
                        haswords.clear();
                        //i移动到当前单词位置(因为跳出当前循环之后，i还要+wordLen)
                        i+=count*wordLen;
                        count=0;
                        break;
                    }
                }
                //情况一，匹配成功
                if (count==wordsNum)result.add(i);
                //如果情况三没有出现
                if (count>0&&!hasRemoved){
                    //移除成功匹配子串的第一个元素
                    String fristWord = s.substring(i, i + wordLen);
                    Integer v = haswords.get(fristWord);
                    haswords.put(fristWord,v-1);
                    count--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}