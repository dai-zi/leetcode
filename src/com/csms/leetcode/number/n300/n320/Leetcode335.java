package com.csms.leetcode.number.n300.n320;
//路径交叉
//困难
public class Leetcode335 {
    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3)
            return false;
        int i, xl = x[1], yl = x[0], px = 0, py = 0;
        //检测a类型路径的变化趋势
        for(i = 2; i < x.length; i++){
            if((i & 0x1) == 1){
                if(x[i] <= xl){
                    //a ---> b
                    if(xl - px <= x[i])
                        yl -= py;
                    xl = x[i];
                    break;
                }
                //用px保存xl的旧值
                px = xl;
                xl = x[i];
            }else {
                if(x[i] <= yl){
                    //a ---> b
                    if(yl - py <= x[i])
                        xl -= px;
                    yl = x[i];
                    break;
                }
                //用py保存yl的旧值
                py = yl;
                yl = x[i];
            }
        }
        //检测b类型路径的变化趋势
        for(i++; i < x.length; i++){
            if((i & 0x1) == 1 && x[i] < xl){
                xl = x[i];
            }else if(x[i] < yl){
                yl = x[i];
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}