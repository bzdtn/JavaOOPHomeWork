package com.bezditnyi.homework.lesson6.copyblocks;

import com.bezditnyi.homework.util.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Viktor Bezditnyi.
 */
public class CopyBlocks {

    public static void main(String... args){
        copy(Constants.FILE_PATH_LESSON_6 + "/Lesson6TestFile.txt", Constants.FILE_PATH_LESSON_6 + "/BlocksCopy.txt");
    }

    public final static int BLOCK_SIZE = 8;

    public static void copy (String src, String dst){
        int threadsCount = (int)((new File(src)).length() - 1) / 8 + 1;
        List<Thread> list = new ArrayList<>(threadsCount);
        IntStream.range(0, threadsCount).forEach((i) -> list.add(CopyThread.getInstance(src, dst, i * BLOCK_SIZE, "Copy " + i)));
    }

    private static class CopyThread extends Thread{
        private String src;
        private String dst;
        private int pos;

        public CopyThread(String src, String dst, int pos, String name){
            super(name);
            this.src = src;
            this.dst = dst;
            this.pos = pos;
        }

        public static CopyThread getInstance(String src, String dst, int pos, String name) {
            CopyThread ct = new CopyThread(src, dst, pos, name);
            ct.start();
            return ct;
        }

        public void run(){
            // Each thread gets its own IO-streams
            byte[] buffer = new byte[BLOCK_SIZE];
            try(RandomAccessFile is = new RandomAccessFile(src, "r");
                RandomAccessFile os = new RandomAccessFile(dst, "rw"))
            {
                is.seek(pos);
                os.seek(pos);
                int len;
                if ((len = is.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

/*    //
    public static void copy1 (String src, String dst){
        try(RandomAccessFile is = new RandomAccessFile(src, "r");
            RandomAccessFile os = new RandomAccessFile(dst, "rw"))
        {
            int threadsCount = (int)is.length() / 8;
            List<Thread> list = new ArrayList<>(threadsCount);
            IntStream.range(0, threadsCount + 1).forEach((i) -> list.add(CoThread.getInstance(is, os,  i * BLOCK_SIZE, "Copy " + i)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class CoThread extends Thread{
        private RandomAccessFile src;
        private RandomAccessFile dst;
        private int pos;

        public CoThread(RandomAccessFile src, RandomAccessFile dst, int pos, String name){
            super(name);
            this.src = src;
            this.dst = dst;
            this.pos = pos;
        }

        public static CoThread getInstance(RandomAccessFile src, RandomAccessFile dst, int pos, String name) {
            CoThread ct = new CoThread(src, dst, pos, name);
            ct.start();
            return ct;
        }

        public void run() {
            byte[] buffer = new byte[BLOCK_SIZE];
            try {
                src.seek(pos);
                dst.seek(pos);
                int len;
                if ((len = src.read(buffer)) > 0) {
                    dst.write(buffer, 0, len);
                }
            } catch (IOException e){
                System.out.println("laja");
                return;
            }
        }
    }
*/
}
