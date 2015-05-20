package com.bezditnyi.homework.lesson3.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class RegularPolygon extends Figure{

    protected int sides;
    protected double a;

    public RegularPolygon(int n, double a){
        super();
        this.name += "RegularPolygon.";
        this.sides = n;
        this.a = a;
    }

    public RegularPolygon(){
        this(3, 0);
    }
    @Override
    public double area() {
        return 0.25 * sides * a * a / Math.tan(Math.PI / sides);
    }

    @Override
    public String toString() {
        return "RegularPolygon{" +
                "name='" + name + '\'' +
                ", n=" + sides +
                ", a=" + a +
                '}';
    }
}
