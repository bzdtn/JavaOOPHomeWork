package com.bezditnyi.homework.lesson3.figure;

public abstract class Figure {
    protected String name;

    //public Figure(String name){
    //    this.name = "Figure"+ name + ".";
    //}
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
}
