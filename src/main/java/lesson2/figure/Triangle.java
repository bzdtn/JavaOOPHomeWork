package lesson2.figure;

/**
 * Created by vbzd on 18.05.2015.
 */
public class Triangle extends Figure {
    private double a;
    private double h;

    public Triangle(String name, double a, double h){
        this.name = super.getName()+ "Triangle" + name + ".";
        this.a = a;
        this.h = h;
    }

    public Triangle(){
        this("", 0, 0);
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
