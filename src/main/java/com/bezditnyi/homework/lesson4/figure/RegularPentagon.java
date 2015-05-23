package com.bezditnyi.homework.lesson4.figure;

/**
 * @author Viktor Bezditnyi.
 */
public class RegularPentagon extends RegularPolygon {

    public RegularPentagon(double a){
        super(5, a);
        this.name += "RegularPolygon.";
    }

    public RegularPentagon(){
        this(0);
    }

    @Override
    public String toString() {
        return "RegularPentagon{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }
}
