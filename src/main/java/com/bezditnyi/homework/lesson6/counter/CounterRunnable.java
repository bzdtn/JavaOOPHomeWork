package com.bezditnyi.homework.lesson6.counter;

/**
 * @author Viktor Bezditnyi.
 */
public class CounterRunnable {
/*
The same as Counter but using interface Runnable.
The problem was to check interruption in .run().
The thread prints numbers from giving range in cycle.
End point is excluded
My modification: if start point greater end point than numbers print in reverse order
 */

    public static void main(String... args) {
        RunnableThread rthrd = new RunnableThread(1, 5, "rcounter");
        Thread thread = new Thread(rthrd);
        thread.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    private static class RunnableThread implements Runnable{

        private String name;
        private int start;
        private int end;
        private int step = 1;

        public RunnableThread(int start, int end, String name) {
            this.name = name;
            this.start = start;
            this.end =  end;
            if (this.start > this.end){
                this.step = -1;
            }
        }

//        @Override
//        public void run() {
//            int out = this.start;
//            while (true){
//                try {
//                    System.out.println(this.getName() + ": " + out);
//                    out += step;
//                    if (out == this.end) {
//                        out = this.start;
//                    }
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    return;
//                }
//            }
//        }
        @Override
        public void run() {
            int out = this.start;
            while (!Thread.currentThread().isInterrupted()){
                    System.out.println(this.getName() + ": " + out);
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

        public String getName() {
            return name;
        }
    }
}
