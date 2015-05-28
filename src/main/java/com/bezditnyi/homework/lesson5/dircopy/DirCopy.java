package com.bezditnyi.homework.lesson5.dircopy;

import com.bezditnyi.homework.util.Constants;

import java.io.*;

/**
 * @author Viktor Bezditnyi.
 */
public class DirCopy {

    public static void dirCopyByte2Byte(String src, String dst){
        File srcDir = new File(src);
        File dstDir = new File(dst);
        for (File srcFile: srcDir.listFiles()){
        //for(String srcFileName: srcDir.list()) {
            //File srcFile = new File(srcDir, srcFileName);
            if(srcFile.isDirectory()){
                System.out.println("Directory " + srcFile.getName() + " skipped");
                continue;
            }
            File dstFile = new File(dstDir, srcFile.getName());
            try (FileInputStream srcStream = new FileInputStream(srcFile);
                 FileOutputStream dstStream = new FileOutputStream(dstFile)) {
                int currentByte = 0;
                while ((currentByte = srcStream.read()) != -1) {
                    dstStream.write(currentByte);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(srcFile.getName() + " copied");
        }
    }

    public static void main(String ... args){
        dirCopyByte2Byte(Constants.FILE_PATH_LESSON_5 + "/src", Constants.FILE_PATH_LESSON_5 + "/dst");
    }
}
