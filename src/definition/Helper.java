package definition;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
    LinkedListDef<definition.Person> list = new LinkedListDef<>();
    Scanner sc = new Scanner(System.in);

    public void add() {
        String s3;
        boolean option = true;
        boolean op1 = true;
        definition.Person p = new definition.Person();
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Please enter the name of the Person:");
        System.out.print("First Name : ");
        String s = sc.nextLine();
        System.out.print("Last Name : ");
        String s1 = sc.nextLine();
        System.out.print("Contact Number : ");
        String n = sc.nextLine();
        arr.add(n);
        while (op1) {
            System.out.println("would you like to add another contact number: y/n");
            String con = sc.nextLine();
            if (con.equals("y")) {
                System.out.print("Contact Number : ");
                n = sc.nextLine();
                arr.add(n);
                op1 = true;
            } else {
                op1 = false;
            }
        }
        System.out.println("Would you like to enter the email addresss:y/n");
        String inq = sc.nextLine();
        if (inq.equals("y")) {
            System.out.print("Enter the email address : ");
            s3 = sc.nextLine();
        } else {
            s3 = null;
        }
        p.setFirst_Name(s);
        p.setLast_Name(s1);
        p.setContact_number(arr);
        p.setEmail(s3);
        list.add(p);
        list.sort(list);
        System.out.println(list.size);
    }

    public void print() {

        for (definition.Person j : list) {
            System.out.println(j);
        }
    }


    public void Search() {
        int count = 0;
        boolean response = false;
        LinkedListDef<definition.Person> l1 = new LinkedListDef<definition.Person>();
        System.out.println("Enter the first name of contact:");
        String search = sc.nextLine();
        for (definition.Person obj : list) {
            if (obj.getFirst_Name().equals(search)) {
                count++;
                l1.add(obj);
                response = true;
            }
        }
        if (response != true) {
            System.out.println("Match does not found !");
        } else {
            System.out.println(count + " Match Found ! ");
            for (definition.Person ob : l1) {
                System.out.println(ob);
            }
        }
    }

    public void delete() {
        int count = 1;
        for (definition.Person ob : list) {
            System.out.println(count + ". " + ob.getFirst_Name() + " " + ob.getLast_Name());
            count++;
        }
        System.out.println("Press the number against the contact to delete it:");
        int del = sc.nextInt();
        definition.Person ob = list.remove(del - 1);
        System.out.println(ob.getFirst_Name() + " " + ob.getLast_Name() + "'s contact  deleted from list.");
    }
}





