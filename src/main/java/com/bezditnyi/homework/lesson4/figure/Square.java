package com.bezditnyi.homework.lesson4.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class Square extends Rectangle {

    public Square(double a){
        super(a, a);
        this.name += "Square." + name;
    }

    public Square(){
        this(0);
    }

    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }
}
