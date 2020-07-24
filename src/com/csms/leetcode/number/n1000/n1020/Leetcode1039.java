package com.csms.leetcode.number.n1000.n1020;
//多边形三角剖分的最低得分
//中等
public class Leetcode1039 {
public int minScoreTriangulation(int[] A) {
        if(A.length < 4){
            return A[0] * A[1] * A[2];
        }else if(A.length < 5){
            return Math.min(A[0] * A[2] *(A[1] + A[3]), A[1]*A[3]*(A[0]+A[2]));
        }
        //记录最小的4个顶点的数组并初始化
        int[] stack = new int[4];
        stack[0] = 0;
        stack[1] = 1;
        stack[2] = 2;
        stack[3] = 3;
        
        sort(A,stack);

        //获取最小的4个顶点，由于4较小，没有使用小顶堆
        for(int i=4;i<A.length;i++){
            if(A[i] < A[stack[0]]){
                stack[3] = stack[2];
                stack[2] = stack[1];
                stack[1] = stack[0];
                stack[0] = i;
            }else if(A[i] < A[stack[1]]){
                stack[3] = stack[2];
                stack[2] = stack[1];
                stack[1] = i;
            }else if(A[i] < A[stack[2]]){
                stack[3] = stack[2];
                stack[2] = i;
            }else if(A[i] < A[stack[3]]){
                stack[3] = i;
            }                
        }       
        

        if(Math.abs(stack[0] - stack[1]) != 1 && Math.abs(stack[0] - stack[1]) != (A.length - 1)){
            //第1小和第2小的顶点不相邻
            return calcByIndex(A,stack[0],stack[1]);
        }else if(Math.abs(stack[0] - stack[2]) != 1  && Math.abs(stack[0] - stack[2]) != (A.length - 1)){
            //第1小和第3小的顶点不相邻
            return calcByIndex(A,stack[0],stack[2]);
        }else{
            if(A[stack[0]] == A[stack[1]]){
                //第1小的顶点和第2小的顶点一样大
                return calcByIndex(A,stack[1],stack[2]);
            }else{
                //第1、2、3小的顶点相邻，且最小顶点在中间，这是最坏的情况，此时有2种可能。
                return Math.min(calcByIndex(A,stack[1],stack[2]),calcByIndex(A,stack[0],stack[3]));
            }
        }        
    }

    //按指定边切分为两个小的多边形
    int calcByIndex(int[] A,int a, int b){
        int minIndex = Math.min(a,b);
        int maxIndex = a + b - minIndex;

        int[] left = new int[(maxIndex-minIndex)+1];
        int[] right = new int[A.length + 2 - left.length];
        System.arraycopy(A,minIndex,left,0,left.length);
        System.arraycopy(A,maxIndex,right,0,A.length - maxIndex);
        System.arraycopy(A,0,right,A.length-maxIndex,minIndex + 1);

        return minScoreTriangulation(left) + minScoreTriangulation(right);
    }

    void sort(int[] arr,int[] index){
        int len = index.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(arr[index[i]] > arr[index[j]]){
                    swap(index,i,j);
                }
            }
        }
    }

    void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
    }
}