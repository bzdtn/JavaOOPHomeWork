package com.bezditnyi.homework.lesson4.figure;

public class Rectangle extends Parallelogram {

    public Rectangle(double a, double b) {
        super(a, b);
        this.name += "Rectangle.";
    }

    public Rectangle(){
        this(0, 0);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + h +
                '}';
    }
}
