package com.bezditnyi.homework.lesson9.universalbox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Viktor Bezditnyi.
 */
public class UniversalBox <T> {
    public static void main(String[] args) {
        int[] aint = {1};
        UniversalBox<Integer> uint = new UniversalBox<>(aint);
        System.out.println(uint.get(0) + " " + uint.get(uint.size() - 1));

        long[] along = {1L, 2L, 0x7ffffffffffffffL};
        UniversalBox<Long> ulong = new UniversalBox<>(along);
        System.out.println(ulong.get(0) + ulong.get(ulong.size() - 1)); // int a+b = (a+b)

        //test of "wrong" use: set int[] into <Double>
        UniversalBox<Double> udouble = new UniversalBox<>(aint);
        System.out.println(udouble.get(0) + " " + udouble.get(udouble.size() - 1));

        char[] ach = {'\u0034', '\u0063'};
        UniversalBox<Character> uch = new UniversalBox<>(ach);
        System.out.println(uch.get(0) + " " + uch.get(uch.size() - 1));

        String[] astring = {"Mam ", "was ", "cleaning ", "the ", "windows"};
        UniversalBox<String> ustring = new UniversalBox<>(astring);
        System.out.println(ustring.get(0) + " " + ustring.get(ustring.size() - 1));
        //UniversalBox<String> uistr = new UniversalBox<String>(aint); // ups,
        // compiles but makes runtime exception: UniversalBox(int[]...) is calling, but not UniversalBox(String[]...)
        //System.out.println(uistr.get(0) + uistr.get(uistr.size() - 1)); // ClassCastException


    }

    private ArrayList array;

    public UniversalBox(T[] array){
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<T>(array.length);
            Arrays.stream(array).forEach(this.array::add);
        }
    }

    public UniversalBox(int[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Integer>(array.length);
            for (int a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(long[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Long>(array.length);
            for (long a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(float[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Float>(array.length);
            for (float a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(double[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Double>(array.length);
            for (double a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(byte[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Byte>(array.length);
            for (byte a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(short[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Short>(array.length);
            for (short a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(char[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Character>(array.length);
            for (char a: array) {
                this.array.add(a);
            }
        }
    }

    public UniversalBox(boolean[] array) {
        if (array == null) {
            this.array = null;
        } else {
            this.array = new ArrayList<Boolean>(array.length);
            for (boolean a: array) {
                this.array.add(a);
            }
        }
    }


    public T get(int i) {
        return (T)this.array.get(i);
    }

    public int size() {
        if (this.array == null) {
            return 0;
        }
        return this.array.size();
    }
}
