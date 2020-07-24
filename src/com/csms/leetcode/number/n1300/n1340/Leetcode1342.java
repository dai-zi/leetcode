package com.csms.leetcode.number.n1300.n1340;
//将数字变成0的操作次数
//简单
public class Leetcode1342 {
public int numberOfSteps (int num) {
int i =0;
while(num!=0) // 不为零就执行循环
if(num%2==0){
num = num/2; //偶数就除2，i++
i++;
}
else{
num= num-1; //奇数减1,i--
i++;
}

     return i;   
}
    public static void main(String[] args) {
    }
}