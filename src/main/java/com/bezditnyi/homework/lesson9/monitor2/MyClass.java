package com.bezditnyi.homework.lesson9.monitor2;

import com.bezditnyi.homework.util.Constants;

public class MyClass {

    private static class MyEvents implements IFileEvents {
        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
        }
        
        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }

        @Override
        public void onFileModified(String path) {
            System.out.println("File modified: " + path);
        }
    }

    public static void main(String[] args) {
        // To test add, delete, modify some files in "Constants.FILE_PATH_LESSON_9"
        // endless cycle
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_9);
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
    }
}