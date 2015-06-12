package com.bezditnyi.homework.lesson9.task4;

import com.bezditnyi.homework.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Viktor Bezditnyi.
 */
public class Task4 {
    public static void main(String[] args) {
        getDirContent(Constants.FILE_PATH_LESSON_5);
    }

    public static void getDirContent(String dirName) {
        File dir = new File(dirName);
        File[] files = dir.listFiles();
        List<File> list = (files == null) ? null : Arrays.asList(files);
        // directory content set to the list

        // try to print 5 elements
        if (list != null) {
            if (list.size() >= 5) {
                list.subList(0, 5).forEach(f -> {
                    try {
                        System.out.println(f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                System.out.println("There are not enough files, just " + list.size());
                list.forEach(f -> {
                    try {
                        System.out.println(f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } else {
            System.out.println("Wrong directory");
        }
    }
}
