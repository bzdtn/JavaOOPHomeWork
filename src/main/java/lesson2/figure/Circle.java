package lesson2.figure;

/**
 * Created by vbzd on 18.05.2015.
 */
public class Circle extends Figure {
    private double r;

    public Circle(String name, double r){
        this.name = super.getName() + "Circle" + name + ".";
        this.r = r;
    }

    public Circle(){
        this("", 0);
    }

    @Override
    public double area() {
        return Math.PI * this.r * this.r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", r=" + r +
                '}';
    }
}
