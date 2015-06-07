package com.bezditnyi.homework.lesson7.dirtree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktor Bezditnyi.
 */
public class DirectoryTree {
    public static void main(String... args){
        String path = "src/main";
        List<String> list = new ArrayList<>();
        try {
            listOfDir(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }

    private static void listOfDir(String path, List<String> list) throws IOException {
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f: files){
                if (isMatch(f.getName())){
                    list.add(f.getCanonicalPath());
                }
                if (f.isDirectory()){
                    listOfDir(f.getCanonicalPath(), list);
                }
            }
        }
    }


    private static boolean isMatch(String name){
        //!!! File extension considered as part of the file name, ex. "defi.io" match the conditions.
        return name.length() > 5 && name.matches("^.e.*"); // The real task pattern = "^.A.*" but there is no one match
    }
    // File name may content an extension.
    // Extension exists if f.isFile()==true and f.lastIndexOf('.')!=-1.
//    private static boolean isMatch(String name, boolean isDir) {
//        int pureNameLength = name.lastIndexOf('.');
//        if (isDir) {
//            pureNameLength = name.length();
//        } else {
//            if (pureNameLength < 0) {
//                pureNameLength = name.length();
//            }
//        }
//        return (pureNameLength > 5 && name.matches("^.e.*"));
//    }

}
