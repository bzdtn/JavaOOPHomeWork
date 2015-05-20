package com.bezditnyi.homework.lesson3.polymorphism.developer;

import java.util.LinkedList;

/**
 * @author Alexander Tyshchenko.
 */
public class DeveloperExample {

	public static void main(String[] args) {
		Developer[] list = {
				new JuniorDeveloper("Mike", 500, 0),
				new JuniorDeveloper("Dima", 500, 1),
				new JuniorDeveloper("Vova", 500, 2),
				new SeniorDeveloper("Jack", 500, 5),
				new TeamLeadDeveloper("Robby", 500, 7),
				new TraineeDeveloper("Petro", 500, 4),
                new SeniorDeveloper("Joe", 500, 10),
                new SeniorDeveloper("Jacob", 500, 7),
                new SeniorDeveloper("Jim", 500, 18),
		};
		StringBuilder sb;

		for (Developer d : list) {
			sb = new StringBuilder() // !!!
				.append(d.getName())
				.append(": ")
				.append(d.getBasicSalary())
				.append(" -> ")
				.append(d.getSalary());

			System.out.println(sb.toString());
		}

        // Seniors with salary more than or equal to 1500.00
        for (Developer dev: list){
            if (dev instanceof SeniorDeveloper & dev.getSalary() >= 1500.0){
                    System.out.println(dev);
            }
        }

        // three lists of developer
        LinkedList<Developer> listJunior = new LinkedList<Developer>();
        LinkedList<Developer> listSenior = new LinkedList<Developer>();
        LinkedList<Developer> listTeamLead = new LinkedList<Developer>();
        for(Developer dev: list){
            if (dev instanceof JuniorDeveloper) {
                listJunior.add(dev);
            } else if (dev instanceof SeniorDeveloper) {
                listSenior.add(dev);
            } else if (dev instanceof TeamLeadDeveloper) {
                listTeamLead.add(dev);
            }
        }
        System.out.println("Juns      " + listJunior);
        System.out.println("Seniors   " + listSenior);
        System.out.println("TeamLeads " + listTeamLead);
    }

    //unused method
    private static String objectIdentifier(Developer obj) {
        if (obj instanceof TraineeDeveloper) {
            return "Trainee";
        } else if (obj instanceof JuniorDeveloper) {
            return "Junior";
        } else if (obj instanceof SeniorDeveloper) {
            return "Senior";
        } else if (obj instanceof TeamLeadDeveloper) {
            return "TeamLead";
        } else {
            return null;
        }
    }
}
