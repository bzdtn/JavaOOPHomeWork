package com.bezditnyi.homework.lesson3.figure;

import java.util.LinkedList;

public class FigureExample {
    public static void main(String [] args){
        Figure [] figures = {
                new Triangle(1, 1),
                new Rectangle(2, 3),
                new Circle(1),
                new Ellipse(2, 1),
                new Parallelogram(12, 3),
                new Diamond(2, 3),
                new RegularPentagon(4),
                new RegularPolygon(5, 4),
                new RegularPolygon(9, 4),
                new Circle(4),
        };

        for (Figure f: figures){
            System.out.println(f + ", area: " + f.area());
        }

    }
}
