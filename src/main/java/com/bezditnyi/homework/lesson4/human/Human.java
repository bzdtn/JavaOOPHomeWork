package com.bezditnyi.homework.lesson4.human;

/**
 * @author Alexander Tyshchenko.
 */
public class Human {

    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "human{" +
                "age=" + age +
                '}';
    }
}
