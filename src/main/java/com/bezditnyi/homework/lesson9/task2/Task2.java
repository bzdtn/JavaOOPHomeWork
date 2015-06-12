package com.bezditnyi.homework.lesson9.task2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Viktor Bezditnyi.
 */
public class Task2 {
/*
Write a method that creates a list, adds to this list 10 elements, deletes the fist, second and last, prints out the list
*/

    public static void main(String... args) {
        createAdnDelete();
    }

    public static void createAdnDelete() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"));
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.forEach(System.out::println);
    }

}
