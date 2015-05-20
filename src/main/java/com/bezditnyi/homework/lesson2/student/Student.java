package com.bezditnyi.homework.lesson2.student;

import java.time.LocalDate;
import java.util.Date;


/**
 * @author Alexander Tyshchenko.
 */
public class Student {
	private String name;
	private String surname;
	private LocalDate birth;
	private Date birthOld;
	
	public Student(String name, String surname, LocalDate birth) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}

	@Deprecated
	public Student(String name, String surname, Date birth) {
		this.name = name;
		this.surname = surname;
		this.birthOld = birth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public LocalDate getBirth() {
		return birth;
	}
	
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
