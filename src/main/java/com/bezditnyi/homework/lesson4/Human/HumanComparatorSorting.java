package com.bezditnyi.homework.lesson4.Human;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanComparatorSorting {

    public static void main(String[] args) {
        Human[] humans = {
                new Human(40),
                new Human(20),
                new Human(3),
                new Human(7),
                new Human(12),
                new Human(23),
                new Human(30),
                new Human(7)

        };

        Arrays.sort(humans, new HumanComparator());
        for (Human h : humans)
            System.out.println(h.getAge());
        System.out.println("--- new decrease comparator ---");
        Arrays.sort(humans, new HumanDecreaseComparator());
        for (Human h : humans)
            System.out.println(h.getAge());

//        Java 8
//        Arrays.stream(humans)
//                .sorted(new HumanComparator())
//                .forEach((h) -> System.out.println(h.getAge()));

    }

}
