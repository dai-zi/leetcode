package com.csms.leetcode.number.n1000.n1020;
//边框着色
//中等
public class Leetcode1034 {
int[][]grid;
    boolean[][]flag;
    int rows;
    int columns;
    int oldColor;
    int color;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        this.color = color;
        this.grid = grid;
        if(grid==null||grid.length==0)
             return grid;
        oldColor = grid[r0][c0];
        rows = grid.length;
        columns = grid[0].length;
        flag = new boolean[rows][columns];
        dfs(r0,c0);
        return grid;
    }
    public int dfs(int i,int j)
    {   
        //不能先判断flag[i][j]再判断grid[i][j]!=oldColor,
        //这样有一个bug(比如第二行的第四个1，是连通分量的边界（上面是2），但可能这个2已经走过了，这样先判断flag[i]就会跳出去了)
        //比如21221
        //    11111
        //    22212
        //    12212
        //    21112
        //r0=1，c0=4，也就是oldColor=1。
        if(i<0||i>=rows||j<0||j>=columns)
            return -1;
         //防止该值被更改过了值
         if(flag[i][j]&&grid[i][j]==color)
            return -1;
        //不管遍历没遍历过只要该值本来就不是连通分量的值，就返回1。
        else if(grid[i][j]!=oldColor){
            return 1;
        }//如果该遍历过了，不再继续遍历了。
        else if(flag[i][j])
            return -1;
       
            
        flag[i][j] = true;
        //边界(要涂色)
        int d = dfs(i+1,j);
        int u = dfs(i-1,j);
        int r = dfs(i,j+1);
        int l = dfs(i,j-1);
        if(i==0||j==0||i==rows-1||j==columns-1)
        {
            grid[i][j] = color;
        }
        else if(d==1||u==1||r==1||l==1)
        { 
            grid[i][j] = color;
        }      
         return -1;
    }
	public static void main(String[] args) {
    }
}