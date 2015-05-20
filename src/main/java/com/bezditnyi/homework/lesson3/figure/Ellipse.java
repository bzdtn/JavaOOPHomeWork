package com.bezditnyi.homework.lesson3.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class Ellipse extends Figure {

    protected double a;
    protected double b;

    public Ellipse(double a, double b){
        super();
        this.name += "Ellipse.";
        this.a = a;
        this.b = b;
    }

    public Ellipse(){
        this(0, 0);
    }

    @Override
    public double area() {
        return Math.PI * this.a * this.b;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
