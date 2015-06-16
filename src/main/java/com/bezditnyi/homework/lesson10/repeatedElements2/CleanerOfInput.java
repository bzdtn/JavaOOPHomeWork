package com.bezditnyi.homework.lesson10.repeatedElements2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Viktor Bezditnyi.
 */

/*
 * Remove repeated elements from the input string of numbers and print out the result
 */
public class CleanerOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();//"4, 2,  1, 2,3,4,  2, 3,\t1, 2, 3, 4";
        String[] elements = inputString.split(",\\s*");
        LinkedHashSet<String> set = new LinkedHashSet<>(elements.length);
        set.addAll(Arrays.asList(elements));
        System.out.println(set.toString());
    }

}
