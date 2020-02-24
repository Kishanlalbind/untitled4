package main;

import definition.Helper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Helper h = new Helper();
        boolean choice = true;
        while (choice) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the contact list");
            System.out.println("Press 1 to add a new contact");
            System.out.println("Press 2 to view all contacts");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit program ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("You have chosen to add a new contact: ");
                    h.add();
                    break;
                case 2:
                    System.out.println("-----------viewing all the elements---------");
                    h.print();
                    break;
                case 3:
                    System.out.println("You could search for a contact from their first names.");
                    h.Search();
                    break;
                case 4:
                    System.out.println("Here all your contacts");
                    h.delete();
                    break;
                case 5:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("Oops! Invalid Number ! Enter the given number !");
            }
            if (choose == 5) {
                choice = false;
            }

        }
    }
}
