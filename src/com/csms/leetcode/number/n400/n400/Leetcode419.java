package com.csms.leetcode.number.n400.n400;
//甲板上的战舰
//中等
public class Leetcode419 {
    public int countBattleships(char[][] board) {
        if(board.length==0 || board[0].length==0) return 0;
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                boolean left=false,right=false,up=false,down=false;
                if(board[i][j]=='X') {
                    if(i+1<m && board[i+1][j]=='X') down=true;
                    if(i-1>=0 && board[i-1][j]=='X') up=true;
                    if(j+1<n && board[i][j+1]=='X') right=true;
                    if(j-1>=0 && board[i][j-1]=='X') left=true;
                    if((down && up) && (right && left)) {
                        dfs(board,i,j);
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(board[i][j]=='X') {
                    board[i][j]='.';
                    ++count;
                    if(i+1<m && board[i+1][j]=='X') {
                        int k=i+1;
                        while(k<m && board[k][j]=='X') board[k++][j]='.';
                    }
                    if(j+1<n && board[i][j+1]=='X') {
                        int k=j+1;
                        while(k<n && board[i][k]=='X') board[i][k++]='.';
                    }
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board,int i,int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='.') return;
        board[i][j]='.';
        int[] a=new int[] {1,0,-1,0};
        int[] b=new int[] {0,1,0,-1};
        for(int k=0;k<4;++k)
        {
            dfs(board,i+a[k],j+b[k]);
        }
    }
    public static void main(String[] args) {
    }
}