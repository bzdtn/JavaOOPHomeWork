package com.bezditnyi.homework.lesson6.timer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * @author Viktor Bezditnyi.
 */
public class Timer {
/*
The thread prints current time every 10 sec.
After special command from console the thread is interrupted.
*/

    public static void main (String... args){
        System.out.println("Type 'stop' to stop TimerThread");
        TimerThread timer = new TimerThread();
        timer.start();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command =  scanner.nextLine();
            if ("stop".equalsIgnoreCase(command)){
                timer.interrupt();
                break;
            }
        }
        System.out.println("Main stopped");
    }

    private static class TimerThread extends Thread{

        public void run(){
            LocalTime tic = LocalTime.now();
            LocalTime toc = LocalTime.now();
            System.out.println("TimerThread started");
            System.out.println(getName() + ": " +  toc.toString());
            while (!isInterrupted()){
                if (toc.isAfter(tic.plusSeconds(10))){
                    System.out.println(getName() + ": " +  toc.toString());
                    tic = toc;
                }
                // I did not know how to check interruption in Runnable
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    return;
//                }
                toc = LocalTime.now();
            }
            System.out.println("TimerThread " + getName() + " stopped");
        }
    }
}
