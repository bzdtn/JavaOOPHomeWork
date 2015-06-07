package com.bezditnyi.homework.lesson8.homosapiens;

import com.bezditnyi.homework.util.Constants;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Viktor Bezditnyi.
 */
public class HumanSerialization {
    public static void main(String... args) {
//        Human h1 = new Human("Bob", "Dealan", LocalDate.of(1990, 9, 22), "CA123456");
//        Human h2 = new Human("Bob", "Deal", LocalDate.of(1991, 1, 22), "CB123456");
//        Human h3 = new Human("Rob", "Dealan", LocalDate.of(1990, 9, 12), "CC123456");
        //Human[] humans = {h1, h2, h3};
        Scanner scanner = new Scanner(System.in);
        Human[] humans = new Human[10];
        String firstName;
        String secondName;
        int year;
        int month;
        int day;
        String id;

        for (int i = 0; i < 10 ; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("First name: ");
            firstName = scanner.nextLine();
            System.out.print("Second name: ");
            secondName = scanner.nextLine();
            System.out.print("Date of birthday, year: ");
            year = Integer.parseInt(scanner.nextLine());
            System.out.print("Date of birthday, month: ");
            month = Integer.parseInt(scanner.nextLine());
            System.out.print("Date of birthday, day: ");
            day = Integer.parseInt(scanner.nextLine());
            System.out.print("ID: ");
            id = scanner.nextLine();
            humans[i] = new Human(firstName, secondName, LocalDate.of(year, month, day), id);
//            System.out.println(humans[i]);
        }

        //System.out.println(h1);

        try (FileOutputStream fos = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "/Humans.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            for(Object h: humans){
                oos.writeObject(h);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Human> humansDeserialized = new ArrayList<>(10);
        Human man;
        boolean isTwin;

        try (FileInputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "/Humans.dat");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
             while ((man = (Human) ois.readObject()) != null) {
                 isTwin = false;
                 for (Human h: humansDeserialized) {
                     if (man.equals(h)){
                         isTwin = true;
                         break;
                     }
                 }
                 if (!isTwin){
                     humansDeserialized.add(man);
                 }
//                try{
//                    for (Human hu: humansDeserialized){
//                        if (man.equals(hu)){
//
//                            throw new HumanDoublingException();
//                        }
//                    }
//                } catch (HumanDoublingException e){
//                    continue;
//                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(humansDeserialized);
    }
}
