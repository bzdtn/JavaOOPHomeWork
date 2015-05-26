package com.bezditnyi.homework.lesson4.Human;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanRight implements Comparable<HumanRight> {

    private int age;

    public HumanRight(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(HumanRight human) {
        if (age < human.getAge()) return 1;
        else if (age == human.getAge()) return 0;
        else if (age > human.getAge()) return -1;
        else
            return 0;
    }
}
