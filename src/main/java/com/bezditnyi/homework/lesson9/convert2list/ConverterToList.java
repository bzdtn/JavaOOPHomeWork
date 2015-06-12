package com.bezditnyi.homework.lesson9.convert2list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Viktor Bezditnyi.
 */
public class ConverterToList {

    public static void main(String... args) {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> newList = convertToList(array);
        newList.forEach(System.out::println);
        String[] strings = {"a", "b", "c", "d"};
        List<String> newStrings = convertToList(strings);
        newStrings.forEach(System.out::println);
    }

    public static <T> List<T> convertToList(T[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.asList(array);
        //ArrayList<T> resList = Arrays.asList(array); //uasia asList returns List<T> BUT NOT LinkedList<T> or ArrayList<T>
    }

    public static List<Integer> convertToList(int [] array) {
        if (array == null) {
            return null;
        }
        List<Integer> resList = new LinkedList<>();
        for (int a: array) {
            resList.add(a);
        }
        return resList;
    }

}
