package com.bezditnyi.homework.lesson3.student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;


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

    public Student()
            throws IllegalStateException,
            DateTimeParseException, IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Surame: ");
        String surname = scanner.nextLine();
        if("".equals(name) | "".equals(surname)){
            throw new IllegalArgumentException("empty name or surname");
        }
        System.out.println("Date (yyyy-mm-dd): ");
        String strDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(strDate);
        if(date.compareTo(LocalDate.now().minusYears(13)) > 0){
            throw new IllegalArgumentException("student is to young");
        }
        this.name = name;
        this.surname = surname;
        this.birth = date;
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
