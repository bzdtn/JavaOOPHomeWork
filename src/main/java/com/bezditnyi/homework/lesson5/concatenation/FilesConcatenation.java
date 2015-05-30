package com.bezditnyi.homework.lesson5.concatenation;

import com.bezditnyi.homework.util.Constants;

import java.io.*;
import java.util.*;

/**
 * @author Viktor Bezditnyi.
 */
public class FilesConcatenation {

    public static void concatenateFilesFromDir(String src, String resFile) throws IOException{
        File dir = new File (src);
        try (OutputStream outStream = new BufferedOutputStream(new FileOutputStream(resFile))) {
            for (File file: dir.listFiles()) {
                if (file.isDirectory()) {
                    continue;
                }
                try (InputStream inStream = new BufferedInputStream(new FileInputStream(file))) {
                    int tmp = 0;
                    while ((tmp = inStream.read()) != -1) {
                        outStream.write(tmp);
                    }
                }
            }
        }
    }

    public static void concatenateSequence(String src, String resFile) throws IOException{
        File dir = new File (src);
        // make list of concatenating files
        List<File> files = new LinkedList<File>();
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) {
                continue;
            }
            files.add(file);
        }
        //
        InputStream sequenceIS = new SequenceInputStream(new ISEnumerator(files));
        try (OutputStream outStream = new BufferedOutputStream(new FileOutputStream(resFile))) {
            int tmp = 0;
            while ((tmp = sequenceIS.read()) != -1) {
                outStream.write(tmp);
            }
        }
    }

    private static class ISEnumerator implements Enumeration<FileInputStream> {
        private Iterator<File> iterator;

        public ISEnumerator(List<File> files) {
            this.iterator = files.iterator();
        }
        @Override
        public boolean hasMoreElements() {
            return iterator.hasNext();
        }

        @Override
        public FileInputStream nextElement() {
            try {
                return new FileInputStream(iterator.next());
            } catch (FileNotFoundException e) {
                return null;
            }
        }
    }

    public static void main (String...args) {
        try {
            concatenateFilesFromDir(Constants.FILE_PATH_LESSON_5 + "/src", Constants.FILE_PATH_LESSON_5  + "/concatenation.dat");
            concatenateSequence(Constants.FILE_PATH_LESSON_5 + "/src", Constants.FILE_PATH_LESSON_5  + "/concatenation1.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
