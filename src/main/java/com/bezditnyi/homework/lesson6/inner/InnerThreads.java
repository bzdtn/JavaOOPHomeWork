package com.bezditnyi.homework.lesson6.inner;

import java.util.stream.IntStream;

/**
 * @author Viktor Bezditnyi.
 */
public class InnerThreads {

    public static void main(String... args){
        ThreadHolder holder = new ThreadHolder();
        holder.start();
        System.out.println("Main stopped");
    }

    private static class InnerThread extends Thread {

        public InnerThread(ThreadGroup group, String name) {
            super(group, name);
        }

        public void run() {
            System.out.println(getName());
            while (!isInterrupted()) {
                //wait
            }
        }
    }

    private static class ThreadHolder extends Thread {

        public void run() {
            ThreadGroup holder = new ThreadGroup("Holder");
            IntStream.range(0, 50).forEach((i) -> {
                InnerThread it = new InnerThread(holder,"Inner # " + i);
                it.start();
            });
            System.out.println("Inner threads created");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            holder.interrupt();
            System.out.println("Holder stopped");
        }
    }
}
