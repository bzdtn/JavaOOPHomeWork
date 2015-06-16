package com.bezditnyi.homework.lesson10.repeatedElements;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Viktor Bezditnyi.
 */
public class RepeatedElementsCounter {
    public static void main(String[] args) {
        Integer[] arrayInt = {9,8,7,6,8,0,1,2,3,4,5,6,7,8,9,0,9,8,7,6,7,8,0,9,8,7,6,5,6};
        System.out.println(countElements(arrayInt));
        System.out.println(countOrderedElements(arrayInt));

        String[] arrayStr = {"T", "h", "e", " ", "d", "e" , "f", "a", "u", "l", "t", " ", "i", "m", "p", "l", "e", "m", "e", "n", "t", "a", "t", "i", "o", "n", " ", "m", "a", "k", "e", "s"};
//        Map<String, Integer> table = counterOfElements(arrayStr);
        System.out.println(countElements(arrayStr));
        System.out.println(countOrderedElements(arrayStr));

    }

    public static <T> HashMap<T, Integer> countElements(T[] array) {
        HashMap<T, Integer> hashMap = new HashMap<>(20);
        for(T a : array) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }
        return hashMap;
    }

    public static <T> TreeMap<T, Integer> countOrderedElements(T[] array) {
        TreeMap<T, Integer> treeMap = new TreeMap<>();
        for(T a : array) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        return treeMap;
    }

}
