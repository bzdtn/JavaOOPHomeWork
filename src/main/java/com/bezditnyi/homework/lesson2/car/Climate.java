package com.bezditnyi.homework.lesson2.car;

public class Climate {
    private boolean on;
    private int temperature;

    public Climate() {
        this.temperature = 20;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Climate{" +
                "on=" + on +
                ", temperature=" + temperature +
                '}';
    }
}
