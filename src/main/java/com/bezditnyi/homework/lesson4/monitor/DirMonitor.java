package com.bezditnyi.homework.lesson4.monitor;

import java.io.File;
import java.util.Date;

/**
 * @author Viktor Bezditnyi.
 */
public class DirMonitor {

    private String directory;
    private FileEvenListener event;

    public DirMonitor(String directory, FileEvenListener event) {
        this.directory = directory;
        this.event = event;
    }

    public void start() {
        boolean isTxtFound = false;
        while (true) {
            File dir = new File(directory);
            if (dir.exists() && dir.isDirectory()) {
                String[] files = dir.list();
                for (String f : files) {
                    if (f.matches(".*\\.txt$")) {
                        if (event != null)
                            event.onFileAdded(directory + "*.txt");
                        System.out.println(new Date(dir.lastModified()));
                        isTxtFound = true;
                        break;
                    }
                }
                if (isTxtFound) break;
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

    public static void main(String[] args) {
        // please, set proper path (directory)
        DirMonitor m = new DirMonitor("c:/Temp/", new FileEvent());
        m.start();
    }
}
