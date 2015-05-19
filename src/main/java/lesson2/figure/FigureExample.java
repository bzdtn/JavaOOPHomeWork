package lesson2.figure;

import java.util.LinkedList;

public class FigureExample {
    public static void main(String [] args){
        Triangle t = new Triangle("11", 1, 1);
        Rectangle r = new Rectangle("my", 1, 1);
        Circle c = new Circle("Kolo", 1);
        System.out.println(t);
        System.out.println(t.getName()+ " area " + t.area());
        System.out.println(r);
        System.out.println(r.getName()+ " area " + r.area());
        System.out.println(c);
        System.out.println(c.getName()+ " area " + c.area());
        //try to use List of Figures
        LinkedList<Figure> figures = new LinkedList<Figure>();
        figures.add(t);
        figures.add(r);
        figures.add(c);
        for (Figure f: figures){
            System.out.println(f.getName()+ " area " + f.area());
        }

    }
}
