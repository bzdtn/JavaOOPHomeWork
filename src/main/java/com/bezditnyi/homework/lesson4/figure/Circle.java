package com.bezditnyi.homework.lesson4.figure;

public class Circle extends Ellipse {

    public Circle(double r){
        super(r, r);
        this.name += "Circle.";
    }

    public Circle(){
        this(0);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", r=" + a +
                '}';
    }
}
