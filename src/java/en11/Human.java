/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en11;

/**
 *
 * @author try
 */
public class Human {

    private int age;
    private String name;

    public Human(String n, int a) {
        this.age = a;
        this.name = n;

    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public String getKind() {
        if (age < 6) {
            return "乳幼児";
        } else if (age >= 6 && age < 12) {
            return "こども";
        } else {
            return "大人";
        }

    }

}
