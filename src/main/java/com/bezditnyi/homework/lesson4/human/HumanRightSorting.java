package com.bezditnyi.homework.lesson4.human;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanRightSorting {

    public static void main(String[] args) {
        HumanRight[] humans = {
                new HumanRight(40),
                new HumanRight(20),
                new HumanRight(3),
                new HumanRight(7)
        };

        Arrays.sort(humans);

        for (HumanRight h : humans)
            System.out.println(h.getAge());

//        Java 8
//        Arrays.stream(humans)
//                .sorted()
//                .forEach((h) -> System.out.println(h.getAge()));
    }
}
