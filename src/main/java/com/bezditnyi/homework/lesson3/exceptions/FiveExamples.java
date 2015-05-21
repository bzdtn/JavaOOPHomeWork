package com.bezditnyi.homework.lesson3.exceptions;

import static java.lang.reflect.Array.getBoolean;
import static java.lang.reflect.Array.setInt;

/**
 * @author Viktor Bezditnyi.
 */
public class FiveExamples {
    public static void main(String[] args){
        try{
            String s1 = null;
            if (s1.equals("asd")){
                System.out.println("hello");
            }
        }
        catch (NullPointerException e){
            System.out.println("Exception: " +  e.getMessage());
        }
        try{
            int x = Math.addExact(0x7fffffff, 0x7fffffff);
        }
        catch (ArithmeticException e){
            System.out.println("Exception: " +  e.getMessage());
        }
        try{
            Byte b = new Byte("12a3");
        }
        catch (NumberFormatException e){
            System.out.println("Exception: " +  e.getMessage());
        }
        try{
            int[] ar = new int[5];
            setInt(ar, 6, 2);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: " +  e.getMessage());
        }
        try{
            int[] ar = new int[5];
            boolean bool = getBoolean(ar, 3);
        }
        catch (IllegalArgumentException e){
            System.out.println("Exception: " +  e.getMessage());
        }

    }
}
