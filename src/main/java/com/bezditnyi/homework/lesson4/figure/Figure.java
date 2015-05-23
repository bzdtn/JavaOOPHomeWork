package com.bezditnyi.homework.lesson4.figure;

public abstract class Figure implements Comparable<Figure>{
    protected String name;

    public Figure(){
        this.name = "Figure.";
    }

    //
    public abstract double area();

    //
    public final String getName() {
        return name;
    }

    @Override
    public abstract String toString();

    public int compareTo(Figure figure){
        if (area() < figure.area()) {
            return -1;
        }
        else if (area() > figure.area()) {
            return 1;
        }
        else return 0;
    }
}
