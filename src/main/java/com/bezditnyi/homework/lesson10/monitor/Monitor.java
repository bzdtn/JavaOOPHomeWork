package com.bezditnyi.homework.lesson10.monitor;

import java.lang.Thread;
import java.lang.InterruptedException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class Monitor
{
    private class MonitorThread extends Thread {
        
        private String path;
        private int timeout;
        private long fileLifeSeconds; // file life in seconds (it is too long to wait a few minutes)
        private HashMap<String, Long> prev = new HashMap<>();
        private HashMap<String, Long> curr = new HashMap<>();
        private IFileEvents events;
        
        public MonitorThread(String path) {
            this.path = path;
            createHashMap(prev);
        }
        
        public void run() {
            while ( ! isInterrupted()) {
                createHashMap(curr);
                compareMaps(prev, curr);
                prev.clear();
                prev.putAll(curr);
                deleteOldFiles();
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

        public long getFileLifeSeconds() {
            return fileLifeSeconds;
        }

        public void setFileLifeSeconds(long fileLifeSeconds) {
            this.fileLifeSeconds = fileLifeSeconds;
        }

        public IFileEvents getEvents() {
            return events;
        }
        
        public void setEvents(IFileEvents value) {
            events = value;
        }
        
        private void doFileChanged(String path) {
            if (events != null)
                events.onFileChanged(path);
        }
        
        private void doFileAdded(String path) {
            if (events != null)
                events.onFileAdded(path);
        }
        
        private void doFileDeleted(String path) {
            if (events != null)
                events.onFileDeleted(path);
        }

        private  void deleteOldFiles(){
            File dir = new File(path);
            File[] files = dir.listFiles();
            if (files != null){
                for(File f : files){
                    if (!f.getName().endsWith(".dat")){ // delete only '.dat' files
                        continue;
                    }
                    LocalDateTime tic = LocalDateTime.ofEpochSecond(f.lastModified() / 1000, 0, ZoneOffset.ofHours(3)).plusSeconds(fileLifeSeconds);
                    LocalDateTime toc = LocalDateTime.now();
                    if (tic.isBefore(toc)) {
                        if (!f.delete()){
                            System.out.println("Can not delete " + f.getName());
                        }
                    }
                }
            }

        }

        private void compareMaps(HashMap<String, Long> m1, HashMap<String, Long> m2) {
            Set<String> keys = m1.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext())
            {
                String path = it.next();
                
                if (m2.containsKey(path)) {
                    long date1 = m1.get(path);
                    long date2 = m2.get(path);
                    
                    if (date2 > date1)
                        doFileChanged(path);
                } else {
                    doFileDeleted(path);
                }
            }
            
            keys = m2.keySet();
            it = keys.iterator();
            while (it.hasNext())
            {
                String path = it.next();
                
                if ( ! m1.containsKey(path))
                    doFileAdded(path);
            }
        }
        
        private void createHashMap(HashMap<String, Long> output) {
            try {
                File file = new File(path);
                File[] list = file.listFiles();
                
                output.clear();
                if (list != null) {// null check added
                    for (File f : list) {
                        output.put(f.getCanonicalPath(), f.lastModified());
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // ---------------------------------- //

    private String path;
    private MonitorThread thread;
    private IFileEvents events;
    private int timeout = 1000;
    private long fileLifeSeconds = 30;
    
    public Monitor(String path) {
        this.path = path;
    }
    
    public void start() {
        thread = new MonitorThread(path);
        thread.setTimeout(timeout);
        thread.setFileLifeSeconds(fileLifeSeconds); // file life in seconds (it is too long to wait a few minutes)
        thread.setEvents(events);
        thread.start();
    }
    
    public void stop() {
        thread.interrupt();
    }
    
    public int getTimeout() {
        return timeout;
    }
        
    public void setTimeout(int value) {
        timeout = value;
    }

    public long getFileLifeSeconds() {
        return fileLifeSeconds;
    }

    public void setFileLifeSeconds(long fileLifeSeconds) {
        this.fileLifeSeconds = fileLifeSeconds;
    }

    public IFileEvents getEvents() {
        return events;
    }
        
    public void setEvents(IFileEvents value) {
        events = value;
    }
}
