package com.bezditnyi.homework.lesson6.hundred;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Viktor Bezditnyi.
 */
public class Hundred {
/*
100 threads are waiting for interruption

There are two types of creation of group of threads: ThreadGroup and List<Thread> with getInstance()
 */

    public static void main(String... args){
        final int threadsCount = 100;
        // using ThreadGroup
        ThreadGroup group = new ThreadGroup("Hundred");
        for (int i = 0; i < threadsCount; i++) {
            OneThread thread = new OneThread(group, "Number " + i);
            thread.start();
        }
        group.interrupt();

        // using List
        List<Thread> threads = new ArrayList<>(threadsCount);
        IntStream.range(0, threadsCount).forEach((i) -> threads.add(OneThread.getInstance("Num " + i)));
        threads.forEach(Thread::interrupt); // lambda method references

        System.out.println("Main stopped");
    }

    private static class OneThread extends Thread{

        public OneThread(String name){
            super(name);
        }

        public OneThread(ThreadGroup group, String name) {
            super(group, name);
        }

        //static to use like OneThread.getInstance("myThread")
        public static OneThread getInstance(String name) {
            OneThread thread = new OneThread(name);
            thread.start();
            return thread;
        }

        public void run(){
            //System.out.println(getId()); // id may not start with 1.
            System.out.println(getName()); // names are more presentable
            while (!isInterrupted()){
                //waiting
            }
            //System.out.println(getName() + " interrupted");
        }
    }
}
