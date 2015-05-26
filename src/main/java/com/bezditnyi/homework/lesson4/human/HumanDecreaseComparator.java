package com.bezditnyi.homework.lesson4.human;

import java.util.Comparator;

/**
 * @author Viktor Bezditnyi.
 */
public class HumanDecreaseComparator implements Comparator<Human>{
    @Override
    public int compare(Human human1, Human human2) {
        if (human1.getAge() < human2.getAge())
            return 1;
        else if (human1.getAge() == human2.getAge())
            return 0;
        else if (human1.getAge() > human2.getAge())
            return -1;
        return 0;
    }
}
