package com.bezditnyi.homework.lesson4.monitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.File;
import java.util.Date;

public class Monitor {
    private String file;
    private FileEvenListener event;

    public Monitor(String file, FileEvenListener event) {
        this.file = file;
        this.event = event;
    }

    public void start() {
        while (true) {
            File f = new File(file);

            if (f.exists() && f.isFile()) {
                Path path = FileSystems.getDefault().getPath(file);
                if (event != null)
                    event.onFileAdded(file);
                System.out.println(new Date(f.lastModified())); // shows time of last modification
                try {
                    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(new Date(attr.creationTime().toMillis())); // shows time of file creation
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
//                break;
            }

            System.out.println("Waiting...");
        }
    }

    public static void main(String[] args) {
        Monitor m = new Monitor("d:/Trash/z.txt", new FileEvent());
        Monitor m1 = new Monitor("d:/Trash/README", new FileEvent());
        Monitor m2 = new Monitor("d:/Trash/testrandom.py", new FileEvent());
        m.start();
        m1.start();
        m2.start();
    }
}
