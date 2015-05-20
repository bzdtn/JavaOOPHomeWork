package com.bezditnyi.homework.lesson2.figure;

public class Circle extends Figure {
    private double r;

    public Circle(String name, double r){
        this.name = super.getName() + "Circle" + name + ".";
        this.r = r;
    }

    public Circle(){
        this("", 0);
    }

    @Override
    public double area() {
        return Math.PI * this.r * this.r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", r=" + r +
                '}';
    }
}
