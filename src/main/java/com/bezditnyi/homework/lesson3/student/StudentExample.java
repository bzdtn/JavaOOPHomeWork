package com.bezditnyi.homework.lesson3.student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class StudentExample {

	public static void main(String[] args) {
		StudentList list = new StudentList();

		/*
		 * Old Date class
		 */
//		list.add(new Student("Dima", "Stepurenko", new Date(1986 - 1900, 1, 1)));
//		list.add(new Student("Vasya", "Pupkin", new Date(1970 - 1900, 3, 28)));

		list.add(new Student("Dima", "Stepurenko", LocalDate.of(1986, 1, 1)));
		list.add(new Student("Vasya", "Pupkin", LocalDate.of(1970, 3, 28)));
		int n = list.find("Vasya");
		System.out.println(list.get(n).getBirth().toString());

//add more students
        list.add(new Student("Sasha", "Sirenko", LocalDate.of(1986, 1, 1)));
        list.add(new Student("Zoya", "Petrenko", LocalDate.of(1990, 8, 28)));
        list.add(new Student("Roma", "Smirnoff", LocalDate.of(1986, 1, 1)));
//find by Surname
        System.out.println("---find by Surname");
		LinkedList<Integer> surnameIds = list.findSurname("Sirenko");
		for (int id: surnameIds){
			System.out.println(list.get(id).getName());
		}
//delete by id
        System.out.println("---delete by id (id=1)");
		System.out.println(list.toString());
		list.dell(1);
		System.out.println(list.toString());
//add more students oversize
        System.out.println("---add more students oversize");
        list.add(new Student("Jora", "Stepurenko", LocalDate.of(1986, 1, 1)));
		list.add(new Student("Vasya", "Pupkin", LocalDate.of(1970, 3, 28)));
		list.add(new Student("Sasha", "Siryy", LocalDate.of(1986, 1, 1)));
		System.out.println(list.toString());
//get oversize
        System.out.println("---\'get\' oversize");
        System.out.println("6: " + list.get(6));
		System.out.println("7: " + list.get(7));
//dell oversize
        System.out.println("---\'dell\' oversize");
		System.out.println("dell 7: " + list.dell(7));
		System.out.println("dell 6: " + list.dell(6));
		System.out.println(list.toString());
//find by name "Sasha": "Sirenko", "Siryy"
        System.out.println("---find by name \'Sasha\': \'Sirenko\', \'Siryy\'");
		System.out.println(list.find("Sasha"));
//find by name non-existent
        System.out.println("---find by name non-existent");
		System.out.println(list.find("ASD"));
//find by surname "Stepurenko": "Dima", "Jora"
        System.out.println("---find by surname \"Stepurenko\": \"Dima\", \"Jora\"");
		surnameIds = list.findSurname("Stepurenko");
		for (int id: surnameIds){
			System.out.println(list.get(id).getName());
		}
		System.out.println(surnameIds);
//find by surname non-existent
        System.out.println("---find by surname non-existent");
		surnameIds = list.findSurname("S");
        for (int id: surnameIds){
            System.out.println(list.get(id).getName());
        }
		System.out.println(surnameIds);
//find by birthday non-existent
        System.out.println("---find by birthday");
        surnameIds = list.findBirth(LocalDate.of(1986, 1, 1));
        for (int id: surnameIds){
            System.out.println(list.get(id).getName());
        }
        System.out.println(surnameIds);

        Scanner scanner = new Scanner(System.in);
        String answer = "e";
        int index = 0;
        while (!"q".equalsIgnoreCase(answer)){
            System.out.println("What would you like to do, q - quit, d - delete, i - insert, p - print list");
            switch (answer){
                case "i": {
                    try {
                        list.add(new Student());
                    }
                    catch (IllegalStateException | DateTimeParseException | IllegalArgumentException e){
                        System.out.println("Exception caught: " + e);
                    }
                    break;
                }
                case "p": {
                    System.out.println(list);
                    break;
                }
                case "q":{
                    System.out.println("Bye");
                    break;
                }
                case "d": {
                    System.out.println("Witch one (0-" + (list.getStudentsNumber() - 1) + ')');
                    index = scanner.nextInt();
                    if(!list.dell(index)){
                        System.out.println("Out of range");
                    }
                    break;
                }
                default:
                    System.out.println("def");
                    break;
            }
        }
        //System.out.println(list);
	}
}
