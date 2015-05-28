package com.bezditnyi.homework.lesson5.concatenation;

import com.bezditnyi.homework.util.Constants;

import java.io.*;

/**
 * @author Viktor Bezditnyi.
 */
public class FilesConcatenation {

    public static void concatenateFilesFromDir(String src, String resFile) throws IOException{
        File dir = new File (src);
        try (FileOutputStream outStream = new FileOutputStream(resFile)) {
            for (String fileName: dir.list()) {
                File file = new File(dir, fileName);
                if (file.isDirectory()) {
                    continue;
                }
                try (FileInputStream inStream = new FileInputStream(file)) {
                    int tmp = 0;
                    while ((tmp = inStream.read()) != -1) {
                        outStream.write(tmp);
                    }
                }
            }
        }
    }

    public static void main (String...args) {
        try (FileOutputStream outStream = new FileOutputStream(Constants.FILE_PATH_LESSON_5  + "/concatenation.dat")) {
            concatenateFilesFromDir(Constants.FILE_PATH_LESSON_5 + "/src", Constants.FILE_PATH_LESSON_5  + "/concatenation.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
