package com.bezditnyi.homework.lesson7.filewriting;

import com.bezditnyi.homework.util.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Viktor Bezditnyi.
 */
public class FileWriting {
    public static void main(String... args){
        copy(Constants.FILE_PATH_LESSON_8 + "/Lesson8TestFile.txt", Constants.FILE_PATH_LESSON_8 + "/BlocksCopy.txt");
    }

    public final static int BLOCK_SIZE = 64;

    public static void copy (String src, String dst){
        int threadsCount = (int)((new File(src)).length() - 1) / BLOCK_SIZE + 1;
        List<Thread> list = new ArrayList<>(threadsCount);

        // clean dst file
        try (FileOutputStream osClean = new FileOutputStream(dst, false)) {
            osClean.write(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(RandomAccessFile is = new RandomAccessFile(src, "r");
            RandomAccessFile os = new RandomAccessFile(dst, "rw"))
        {
            IntStream.range(0, threadsCount).forEach((i) -> list.add(CopyThread.getInstance(is, os, i * BLOCK_SIZE, "Copy " + i)));
            list.forEach((l) -> {
                try {
                    l.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.out.println("copy"); // e.printStackTrace();
        }
    }

    private static class CopyThread extends Thread{
        private final RandomAccessFile src;
        private final RandomAccessFile dst;
        private int pos;
        private final static Object lock = new Object();

        public CopyThread(RandomAccessFile src, RandomAccessFile dst, int pos, String name){
            super(name);
            this.src = src;
            this.dst = dst;
            this.pos = pos;
        }

        public static CopyThread getInstance(RandomAccessFile src, RandomAccessFile dst, int pos, String name) {
            CopyThread ct = new CopyThread(src, dst, pos, name);
            ct.start();
            return ct;
        }

        public void run(){
            byte[] buffer = new byte[BLOCK_SIZE];
            synchronized (lock) {
                try {
                    src.seek(pos);
                    dst.seek(pos);
                    int len;
                    if ((len = src.read(buffer)) > 0) {
                        System.out.println(this.getName() + ", pos=" + pos + ", len=" + len);
                        dst.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    System.out.println("Thread IOException");
                    e.printStackTrace();
                }
            }
        }
    }

}
