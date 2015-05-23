package com.bezditnyi.homework.lesson4.figure;

public class Triangle extends Figure {
    private double a;
    private double h;

    public Triangle(double a, double h){
        this.name += "Triangle.";
        this.a = a;
        this.h = h;
    }

    public Triangle(){
        this(0, 0);
    }

    @Override
    public double area() {
        return 0.5 * this.a * this.h;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", h=" + h +
                '}';
    }
}
