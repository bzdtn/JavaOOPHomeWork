package com.bezditnyi.homework.lesson2.car;

public class CarExample {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000, 5.0);

        System.out.println(bmw);
        System.out.println(ferrari);

        bmw.turnOn();
        ferrari.turnOn();

        final int[] speeds = {20, 60, 100};

        for (int s : speeds)
            bmw.start(s, 0.5);
//        Java 8
//        Arrays.stream(speeds).forEach((s) -> bmw.start(s, 0.5));
        for (int s : speeds)
            ferrari.start(s, 1);
//        Java 8
//        Arrays.stream(speeds).forEach((s) -> ferrari.start(s, 0.5));


        bmw.turnOff();
        ferrari.turnOff();

        System.out.println(bmw.getName() + ": " + bmw.getMileage() + " (km), " + bmw.getConsumption() + " (l)");
        System.out.println(ferrari.getName() + ": " + ferrari.getMileage() + " (km), " + ferrari.getConsumption() + " (l)");
    }
}
