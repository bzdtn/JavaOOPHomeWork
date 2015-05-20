package com.bezditnyi.homework.lesson2.car;

public class Engine {
    private double mileage;
    private boolean started;
    private double capacity; //объем двигателя

    public Engine(double mileage, double capacity) {
        this.mileage = mileage;
        this.capacity = capacity;
    }

    public double getMileage() {
        return mileage;
    }

    //расход топлива (л на 100 км) в зависимости от объема двигателя
    public double getConsumption(){
        if (this.capacity < 1.1) {
            return 5.0;
        } else if (this.capacity < 1.5){
            return 7.0;
        } else if (this.capacity < 2.0){
            return 8.0;
        } else if (this.capacity < 3.0){
            return 11.0;
        } else if (this.capacity < 4.0){
            return 12.5;
        } else if (this.capacity < 5.0){
            return 18.0;
        } else if (this.capacity < 6.0){
            return 19.0;
        } else {
            return 22.0;
        }
    }

    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }

    public boolean isStarted() {
        return started;
    }

    public void turnOn() {
        started = true;
    }

    public void turnOff() {
        started = false;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "mileage=" + mileage +
                ", started=" + started +
                ", capacity=" + capacity +
                '}';
    }
}
