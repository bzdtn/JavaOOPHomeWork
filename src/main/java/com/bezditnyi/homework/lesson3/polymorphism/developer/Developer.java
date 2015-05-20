package com.bezditnyi.homework.lesson3.polymorphism.developer;

/**
 * @author Alexander Tyshchenko.
 */
public abstract class Developer {

	protected String name;
	protected double basicSalary;
	protected int experience;
	
	public Developer(String name, double basicSalary, int experience) {
		this.name = name;
		this.basicSalary = basicSalary;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	
	public abstract double getSalary();

    // simple toString
    @Override
    public String toString() {
        return name + ": " + basicSalary + " -> " + getSalary();
    }
}
