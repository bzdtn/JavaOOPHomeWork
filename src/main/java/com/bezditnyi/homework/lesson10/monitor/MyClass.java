package com.bezditnyi.homework.lesson10.monitor;

import com.bezditnyi.homework.util.Constants;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MyClass {

    static class MyStop extends Thread {
        private Monitor s;
        
        public MyStop(Monitor s) {
            this.s = s;
        }
        
        public void run() {
            s.stop();
        }
    }

    private static class MyEvents implements IFileEvents {
        public void onFileChanged(String path) {
            System.out.println("File changed: " + path);
            //Shows additional info of file
            File file = new File(path);
            System.out.println("changed: " + LocalDateTime.ofEpochSecond(file.lastModified()/1000, 0, ZoneOffset.ofHours(3)).toString());
            System.out.println("size: " + file.length() + " bytes");
            System.out.println("is hidden: " + file.isHidden());
        }
        
        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
            //Shows additional info of file
            File file = new File(path);
            System.out.println("changed: " + LocalDateTime.ofEpochSecond(file.lastModified()/1000, 0, ZoneOffset.ofHours(3)).toString());
            System.out.println("size: " + file.length() + " bytes");
            System.out.println("is hidden: " + file.isHidden());
        }
        
        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }
    }

    public static void main(String[] args) {
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_10);
        m.setTimeout(2000);
        m.setFileLifeSeconds(30);
        m.setEvents(new MyEvents());
        m.start();
        
        Runtime.getRuntime().addShutdownHook(new MyStop(m));
    }
}