package com.bezditnyi.homework.lesson9.monitor2;

import java.lang.InterruptedException;
import java.util.Iterator;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Monitor {
    private String path;
    private int timeout;
    private List<String> prev = new LinkedList<>();
    private List<String> curr = new LinkedList<>();

    //new, keeps file name and last modification date
    private List<FileInfo> prevInfo = new LinkedList<>();
    private List<FileInfo> currInfo = new LinkedList<>();

    private IFileEvents events;

    public Monitor(String path) {
        this.path = path;
        createList(prev, prevInfo);
    }

    public void start() {
        while (true) {
            createList(curr, currInfo);
            compareLists(prev, curr, prevInfo, currInfo);
            prev.clear();
            prevInfo.clear();
            prev.addAll(curr);
            prevInfo.addAll(currInfo);

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int value) {
        timeout = value;
    }

    public IFileEvents getEvents() {
        return events;
    }

    public void setEvents(IFileEvents value) {
        events = value;
    }

    private void doFileAdded(String path) {
        if (events != null)
            events.onFileAdded(path);
    }

    private void doFileDeleted(String path) {
        if (events != null)
            events.onFileDeleted(path);
    }

    // new
    private void doFileModified(String path) {
        if (events != null)
            events.onFileModified(path);
    }

    private void compareLists(List<String> prev, List<String> curr, List<FileInfo> prevMod, List<FileInfo> currMod) {
        Iterator<String> it = prev.iterator();
        String path;

        while (it.hasNext()) {
            path = it.next();
            if ( ! curr.contains(path))
                doFileDeleted(path);
        }

        it = curr.iterator();
        while (it.hasNext()) {
            path = it.next();
            if ( ! prev.contains(path))
                doFileAdded(path);
        }

        // checks modification
        Iterator<FileInfo> itMod = prevMod.iterator();
        FileInfo info;
        while (itMod.hasNext()){
            info = itMod.next();
            if (!currMod.contains(info)){
                doFileModified(info.getFileName());
            }
        }
    }

    private void createList(List<String> output, List<FileInfo> info) {
        try {
            File file = new File(path);
            File[] list = file.listFiles();

            output.clear();
            info.clear();
            if (list != null) {
                for (File f : list) {
                    output.add(f.getCanonicalPath());
                    info.add(new FileInfo(f.getCanonicalPath(), f.lastModified()));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // new, container for "file info"
    private class FileInfo{
        private String fileName;
        private long modTime;

        public FileInfo(String fileName, long modTime) {
            this.fileName = fileName;
            this.modTime = modTime;
        }

        public String getFileName() {
            return fileName;
        }

        public long getModTime() {
            return modTime;
        }

        // equals - hashCode override because of "equals"
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FileInfo fileInfo = (FileInfo) o;

            if (modTime != fileInfo.modTime) return false;
            return !(fileName != null ? !fileName.equals(fileInfo.fileName) : fileInfo.fileName != null);

        }

        @Override
        public int hashCode() {
            int result = fileName != null ? fileName.hashCode() : 0;
            result = 31 * result + (int) (modTime ^ (modTime >>> 32));
            return result;
        }
    }
}
