package com.bezditnyi.homework.lesson4.figure;

/**
 * @author Viktor Bezditnyi.
 */
public abstract class Quadrilateral extends Figure {

    static final private int sides = 4;

    public Quadrilateral(){
        super();
        this.name += "Quadrilateral.";
    }

    public static int getSides() {
        return sides;
    }
}
