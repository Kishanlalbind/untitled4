package definition;

import java.util.ArrayList;

public class Person {
    private String First_Name ;
    private String Last_Name;
    private ArrayList<String> arr;
    private String email;

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String>  getContact_number() {
        return arr;
    }

    public void setContact_number(ArrayList<String> arr) {
        this.arr = arr;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }



    @Override
    public String toString() {
        return "-------- * -------- * -------- * --------" + "\n" +
                "First Name : " + First_Name + "\n" + "Last Name : " + Last_Name + "\n" + "ContactNumber: " + arr.toString() + "\n" + "Email Address : " + email + "\n" +
                "-------- * -------- * -------- * --------";
    }
}

