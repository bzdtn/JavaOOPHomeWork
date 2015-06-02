package com.bezditnyi.homework.lesson6.counter;

/**
 * @author Viktor Bezditnyi.
 */
public class Counter {
/*
The thread prints numbers from giving range in cycle.
End point is excluded (exclusive).
My modification: if start point greater end point than numbers print in reverse order
 */

    public static void main (String... arg) {
        CounterThread thread = new CounterThread(7, 11, "counter");
        thread.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("Main stopped");
    }

    private static class CounterThread extends Thread {

        private int start;
        private int end;
        private int step = 1;
        // default constructor: start = 0, end = 10, step = 1; end excluded
        public CounterThread (String name) {
            super(name);
            this.start = 0;
            this.end = 10;
            this.step = 1;
        }
        // constructor; end excluded
        public CounterThread (int start, int end, String name){
            super(name);
            this.start = start;
            this.end = end;
            if (this.start > this.end){
                this.step = -1;
            }
        }

        public void run(){
            int out = this.start;
            while (!isInterrupted()) {
                System.out.println(getName() + ": " + out);
                out += step;
                if (out == this.end) {
                    out = this.start;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
