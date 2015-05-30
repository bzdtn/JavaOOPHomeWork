package com.bezditnyi.homework.lesson5.helloto1234;

import com.bezditnyi.homework.util.Constants;

import java.io.*;
import java.nio.CharBuffer;

/**
 * @author Viktor Bezditnyi.
 */
public class Replacer {

    public static void main(String...args){
        File file = new File(Constants.FILE_PATH_LESSON_5 + "/Lesson5TestFile.txt");
        byte[] data = new byte[(int) file.length()];
        try (FileInputStream is = new FileInputStream(file)) {
            // reading whole file, it is bad if file is huge
            is.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = new String(data);
        s = s.replaceAll("Hello", "1234");
        try (FileOutputStream os = new FileOutputStream(file)) {
            os.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
