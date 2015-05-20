package com.bezditnyi.homework.lesson2.car;

public class Car {
    private String name;
    private Engine engine;
    private Climate climate = new Climate();

    public Car(String name) {
        this(name, 0, 1.6);
    }

    //переопределен конструктор: добавлен объем двигателя
    public Car(String name, double mileage, double capacity) {
        this.name = name;
        engine = new Engine(mileage, capacity);
    }

    public Car(String name, double capacity) {
        this.name = name;
        engine = new Engine(0, capacity);
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return engine.getMileage();
    }

    //потраченное топливо = расход * пробег / 100
    public double getConsumption(){
        return engine.getConsumption() * engine.getMileage() / 100.0;
    }

    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }

    public void turnOff() {
        climate.turnOff();
        engine.turnOff();
    }

    public void start(int speed, double hours) {
        if (engine.isStarted()) {
            double distance = hours * speed;
            engine.addMileage(distance);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                ", climate=" + climate +
                '}';
    }
}
