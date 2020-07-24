package com.csms.leetcode.util;

import java.io.*;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ClassGenerator {
    private final String BASEDIR = "C:\\file\\delete\\";
    private final String PROBLEM_TEXT = "problem1.txt";

    private List<String> lines = new ArrayList<>();

    public ClassGenerator(){
        FileReader fr;
        BufferedReader br;
        try {
            //fr = new FileReader(BASEDIR + PROBLEM_TEXT);
            FileInputStream fis = new FileInputStream(BASEDIR + PROBLEM_TEXT);
            InputStreamReader ir = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(ir);
            String str = null;
            while((str = br.readLine()) != null){
                lines.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generator(){
        //生成一级目录
        for(int i = 0; i < 2000; i += 100){
            File f = new File(BASEDIR + "n" + i);
            try {
                f.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //生成二级目录
        for(int i = 0; i < 2000; i++){
            if(i % 20 == 0){
                File tmp = new File(BASEDIR + "n" + (i / 100) * 100 + "//" + "n" + i);
                tmp.mkdir();
            }
        }
        //
        File tmp = new File(BASEDIR + "other");
        tmp.mkdir();
        tmp = new File(BASEDIR + "other//other");
        tmp.mkdir();

        //根据problems生成文件
        for(int i = 0; i < lines.size(); i ++){
            try {
                String[] strs = lines.get(i).split(" ");
                String firstPackageName;
                String secondPackageName;
                String finalName;
                int seq = getSeq(strs[0]);
                if(seq == -1){
                    firstPackageName = "other";
                    secondPackageName = "other";
                    finalName = BASEDIR + firstPackageName + "\\" + secondPackageName + "\\Leetcode" + strs[0] + ".java";
                }else {
                    firstPackageName = "n" + (seq / 100) * 100;
                    secondPackageName = "n" + (seq / 20) * 20;
                    finalName = BASEDIR + firstPackageName + "\\" + secondPackageName + "\\Leetcode" + strs[0] + ".java";
                }
                System.out.println(finalName);
                File f = new File(finalName);
                f.createNewFile();

                FileOutputStream fw = new FileOutputStream(finalName);
                OutputStreamWriter brs = new OutputStreamWriter(fw,"UTF-8");
                BufferedWriter bw = new BufferedWriter(brs);
                String res = createClassFile(firstPackageName, secondPackageName, strs[1], strs[2], strs[0]);
                bw.write(res);
                bw.flush();
                bw.close();
                fw.close();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }


    }
    public int getSeq(String str){
        int res = -1;
        try{
            res = Integer.valueOf(str);
        }catch (Exception e){
            ;
        }
        return res;
    }
    public String createClassFile(String firstPackageName, String secondPackageName, String name, String difficulty, String seq){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.csms.leetcode.number." + firstPackageName + "." + secondPackageName + ";\n");
        sb.append("//" + name + "\n");
        sb.append("//" + difficulty + "\n");
        sb.append("public class Leetcode" + seq + " {\n");
        sb.append("\n");
        sb.append("    public static void main(String[] args) {");
        sb.append("\n");
        sb.append("    }");
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }
    public static void main(String[] args) {
        new ClassGenerator().generator();
    }
}
