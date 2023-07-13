package com.practice.OneOneBi.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phone_no;
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @JsonManagedReference

    public Laptop laptop;

    public Person(int id, String name, long phone_no) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;

    }

    public Person() {
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }
}
