
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "regno")
    private int regno;

    @Column(name = "cgpa")
    private double cgpa;

    @Column(name = "name", length = 100)
    private String name;

    public Student() {
    }

    public Student(int regno, double cgpa, String name) {
        this.regno = regno;
        this.cgpa = cgpa;
        this.name = name;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
