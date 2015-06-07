package com.bezditnyi.homework.lesson7.sum;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Viktor Bezditnyi.
 */
public class Sum {
    public static final int ARRAY_SIZE = 10_000_000;
    public static final int RANDOM_UPPER_BOUND = Integer.MAX_VALUE / ARRAY_SIZE / 2;
    public static final int NUMBER_OF_THREADS = 10;// (ARRAY_SIZE - 1) / PER_THREAD + 1;
    public static final int PER_THREAD = (ARRAY_SIZE - 1) / NUMBER_OF_THREADS + 1; //2_500_000;


    public static void main (String... args) {
        // creating random array
        int[] array = new int[ARRAY_SIZE];
        Random rng = new Random(LocalTime.now().toNanoOfDay());
        for (int i = 0; i < array.length; i++) {
            array[i] = rng.nextInt(RANDOM_UPPER_BOUND);
        }

        long tic = System.nanoTime();
        AtomicInteger sum = new AtomicInteger(0);
        List<Thread> list = new ArrayList<>(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            SumThread t = new SumThread(i * PER_THREAD, (i + 1) * PER_THREAD, array, sum);
            t.start();
            list.add(t);
        }
        for(Thread t: list){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sum + " thread " + (System.nanoTime() - tic) + " ns");

        tic = System.nanoTime();
        int s = 0;
        for (int a: array){
            s += a;
        }
        System.out.println(s + " brutal " + (System.nanoTime() - tic) + " ns");
    }
}

class SumThread extends Thread {
    private final int from;
    private final int to;
    private int[] array;
    private AtomicInteger s;

    public SumThread(int from, int to, int[] array, AtomicInteger sum){
        this.from = from;
        this.to = (to > array.length) ? array.length: to;
        this.array = array;
        this.s = sum;
    }

    public void run() {
        int sumInThread = 0;
        for (int i = from; i < to; i++) {
            sumInThread += this.array[i];
        }
        s.addAndGet(sumInThread);
    }
}
