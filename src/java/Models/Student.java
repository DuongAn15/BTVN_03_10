/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author MY PC
 */
public class Student {
    public static int count = 0;
    private int ID;
    private String name;
    private int age;
    private String major;

    public Student() {
    }

    public Student(String name, int age, String major) {
        ID = count++;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + this.name + "\nAge: " + this.age + "\nMajor: " + this.major + "\n"; 
    }
}
