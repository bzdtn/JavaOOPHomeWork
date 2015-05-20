package com.bezditnyi.homework.lesson3.polymorphism.developer;

/**
 * @author Viktor Bezditnyi.
 */
public class TraineeDeveloper extends Developer {

    /**
     * Constructs a new {@code TraineeDeveloper} object.
     *
     * @param      name {@code String} value.
     * @param      basicSalary {@code double} value.
     * @param      experience {@code int} value, in months.
     */
    public TraineeDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    /**
     * Returns {@code double} value of salary.
     */
    @Override
    public double getSalary() {
        return basicSalary / 2 + (experience > 0 ? basicSalary * experience * 0.05 : 0);
    }
}
