package com.bezditnyi.homework.lesson5.file;

import com.bezditnyi.homework.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Viktor Bezditnyi.
 */
public class FileSearcher {

    private static List<String> findFiles(String srcPath, String ext) throws IOException {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFileFilter(ext));
        //  ArrayList is better because it allocates exactly enough memory to keep file names
        List<String> listFiles = new ArrayList<>(files.length);
        // "/" added to separate dir name from file name
        for (File file: files){
            listFiles.add(srcPath + "/" + file.getName());
        }
        return listFiles;
    }

    private static List<String> findFilesWithExtensions(String srcPath, String[] exts) throws IOException{
        File dir = new File(srcPath);
        List<File> files = new LinkedList<>();
        for (String ext: exts) {
            files.addAll(Arrays.asList(dir.listFiles(new MyFileFilter(ext))));
        }
        List<String> listFiles = new ArrayList<String>(files.size());
        files.forEach((f) -> listFiles.add(srcPath + "/" + f.getName()));
//        for (File file: files){
//            listFiles.add(srcPath + "/" + file.getName());
//        }
        return listFiles;
    }

    public static void main(String[] args){
        try{
            List<String> files = findFiles(Constants.FILE_PATH_LESSON_5, ".txt");
            for(String fileName: files){
                System.out.println(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--- find files with given extensions ---");
        try{
            String[] exts = {".ini", ".dll"};
            List<String> files = findFilesWithExtensions(Constants.FILE_PATH_LESSON_5, exts);
            files.forEach(System.out::println);
//            for(String fileName: files){
//                System.out.println(fileName);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--- filter that accepts only files but not directories ----");
        File dir = new File(Constants.FILE_PATH_LESSON_5);
        for (File f: dir.listFiles(new FileOnlyFilter())){
            System.out.println(f.toString());
        }
    }
}
