package com.bezditnyi.homework.lesson7.monitor;

import com.bezditnyi.homework.util.Constants;

import java.io.File;
import java.util.Date;

/**
 * @author Viktor Bezditnyi.
 */
public class Monitor {
// monitors of adding of ".txt" file into the directory or into subdirectories
    private String directory;
    private IFileEvenListener event;

    public Monitor(String directory, IFileEvenListener event) {
        this.directory = directory;
        this.event = event;
    }
    public void start() {
        while (true) {
            File dir = new File(directory);
            if (isTxtFound(dir)) {
                break;
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                //nothing
            }
            System.out.println("Waiting...");
        }
    }

    private boolean isTxtFound(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) { // nullPointer avoiding
                for (File f: files) {
                    if (f.isFile() && f.getName().matches(".*\\.txt$")) {
                        if (event != null) {
                            event.onFileAdded(f.toString());
                        }
                        System.out.println(new Date(dir.lastModified()));
                        return true;
                    }
                    if (f.isDirectory()) { // if directory occurs, going deeper
                        if (isTxtFound(f)) {
                            return true;
                        } // if there is no .txt in subdirectories, going further
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_7, new FileEvent());
        m.start();
    }
}
