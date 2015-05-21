package com.bezditnyi.homework.lesson3.student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author Alexander Tyshchenko.
 */
public class StudentList {
	private int listMaxSize = 5; //текущий размер массива
	private Student[] list = new Student[5];
	private int p = 0;

	public void add(Student s) {
		if (p >= this.listMaxSize) {
			//resize
            this.resize();
		}
		list[p++] = s;
	}

    //make new array size of "listMaxSize + 5"
    //copy to new array
    //set this.list to new array
    private void resize() {
        Student[] tmpList = new Student[listMaxSize + 5];
        System.arraycopy(list, 0, tmpList, 0, listMaxSize);
        list = tmpList;
        listMaxSize += 5;
    }

	public Student get(int n) {
		if (n < p & n >= 0) {
            return list[n];
        } else {
            return null;
        }
	}
	
	public int find(String name) {
		for (int i = 0; i < p; i++) {
			if (list[i].getName().equalsIgnoreCase(name))
				return i;
		}
		return -1;
	}

    //returns list of ids for surname in the list
	public LinkedList<Integer> findSurname(String surname) {
        LinkedList<Integer> finds = new LinkedList<Integer>();
		for (int i = 0; i < p; i++) {
			if (list[i].getSurname().equalsIgnoreCase(surname)) {
                finds.add(i);
            }
		}
		return finds;
	}

    //returns list of ids for date in the list
    public LinkedList<Integer> findBirth(LocalDate date) {
        LinkedList<Integer> finds = new LinkedList<Integer>();
        for (int i = 0; i < p; i++) {
            if (list[i].getBirth().equals(date)) {
                finds.add(i);
            }
        }
        return finds;
    }

    //try to dell from the list by id
    //returns true if it is possible
	public boolean dell(int id){
		if (id < 0 | id >= this.p) {
			return false;
		} else {
//            for (int i = id; i < this.p - 1; i++) {
//                this.list[i] = this.list[i + 1];
//            }
            System.arraycopy(this.list, id + 1, this.list, id, this.p - id - 1);
            this.list[this.p - 1] = null;
            this.p--;
            return true;
        }
	}

    public int getStudentsNumber() {
        return p;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "listMaxSize=" + listMaxSize +
                ", p=" + p +
                ", list=" + Arrays.toString(list) +
                '}';
    }
}
