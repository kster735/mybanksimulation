/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltools;

/**
 *
 * @author E2
 */
public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        setLastName(lastName);
        setFirstName(firstName);
        setAge(age);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "<Person>\n"
                + "\t<firstName>"+ this.firstName +"</firstName>\n"
                + "\t<lastName>"+this.lastName+"</lastName>\n"
                + "\t<age>"+this.age+"</age>\n"
                + "</Person>\n";
    }
}


