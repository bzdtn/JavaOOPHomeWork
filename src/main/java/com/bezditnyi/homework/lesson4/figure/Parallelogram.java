package com.bezditnyi.homework.lesson4.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class Parallelogram extends Quadrilateral {
    protected double a;
    protected double h;

    public Parallelogram(double a, double h){
        super();
        this.name += "Parallelogram.";
        this.a = a;
        this.h = h;
    }

    public Parallelogram(){
        this(0, 0);
    }

    @Override
    public double area() {
        return this.a * this.h;
    }

    @Override
    public String toString() {
        return "Parallelogram{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", h=" + h +
                '}';    }
}
