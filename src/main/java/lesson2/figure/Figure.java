package lesson2.figure;

/**
 * Created by vbzd on 18.05.2015.
 */
public abstract class Figure {
    protected String name;

    public Figure(String name){
        this.name = "Figure"+ name + ".";
    }
    public Figure(){
        this("");
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
