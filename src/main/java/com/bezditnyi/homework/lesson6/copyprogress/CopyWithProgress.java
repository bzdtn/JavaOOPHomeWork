package com.bezditnyi.homework.lesson6.copyprogress;

import com.bezditnyi.homework.util.Constants;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Viktor Bezditnyi.
 */
public class CopyWithProgress {
    public static void main(String... args) {
        Copy c = new Copy(Constants.FILE_PATH_LESSON_6 + "/Lesson6TestFile.txt", Constants.FILE_PATH_LESSON_6 + "/res.txt", new ProgressPercent());
        c.start();
    }


    private interface IProgress {
        void update(double p);
    }

    private static class ProgressPercent implements IProgress {
        private long n = 0;
        @Override
        public void update(double p) {
            System.out.format("%.2f\n", p);  //printf("%.2f\n", p);
        }
    }

    private static class Copy extends Thread {
        private static final int BLOCK_SIZE = 64;
        private String src;
        private String dst;
        private IProgress progress;
        private long counter;

        public Copy(String src, String dst, IProgress progress){
            this.src = src;
            this.dst = dst;
            this.progress = progress;
        }

        public void run(){
            try {
                copyFile();
            } catch (IOException e) {
                return;
            }

        }

        private void copyFile() throws IOException {
            try (RandomAccessFile is = new RandomAccessFile(this.src, "r")) {
                double percent = is.length() / 100.0;
                counter = 0;
                try (RandomAccessFile os = new RandomAccessFile(this.dst, "rw")){
                    byte[] buffer = new byte[BLOCK_SIZE];
                    int len;
                    do {
                        if ((len = is.read(buffer, 0, buffer.length)) > 0) {
                            os.write(buffer, 0, len);
                            counter += len;
                            progress.update(counter/percent);
                            try{
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } while(len > 0);
                }
            }
        }
    }
}
