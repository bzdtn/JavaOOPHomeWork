package com.bezditnyi.homework.lesson8.homosapiens;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Viktor Bezditnyi.
 */
public class Human implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String secondName;
    private final LocalDate birthday;
    private String id;

    public Human(String firstName, String secondName, LocalDate birthday, String id){
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!firstName.equals(human.firstName)) return false;
        if (secondName != null ? !secondName.equals(human.secondName) : human.secondName != null) return false;
        if (!birthday.equals(human.birthday)) return false;
        return id.equals(human.id);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + birthday.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + ' ' +
                secondName +
                ", born " + birthday.toString() +
                ", id=" + id;
    }
}

class HumanDoublingException extends IllegalArgumentException{

    public HumanDoublingException() {
        super();
    }
    public HumanDoublingException(String s) {
        super(s);
    }
    public HumanDoublingException(String s, Throwable cause) {
        super(s, cause);
    }

}