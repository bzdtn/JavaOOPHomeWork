package lesson2.figure;

/**
 * Created by vbzd on 18.05.2015.
 */
public class Rectangle extends Figure{
    private double a;
    private double b;

    public Rectangle(String name, double a, double b) {
        this.name = super.getName() + "Rectangle" + name + ".";
        this.a = a;
        this.b = b;
    }

    public Rectangle(){
        this("", 0, 0);
    }

    @Override
    public double area() {
        return this.a * this.b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
