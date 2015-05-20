package com.bezditnyi.homework.lesson3.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class Diamond extends Parallelogram{

    public Diamond(double a, double h){
        super(a, h);
        this.name += "Parallelogram.";
    }

    public Diamond(){
        this(0, 0);
    }
    @Override
    public String toString() {
        return "Diamond{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }
}
