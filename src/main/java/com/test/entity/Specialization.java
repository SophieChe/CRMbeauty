package com.test.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specializations")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    public Specialization() {
    }

    public Specialization(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "specializations")
    private Set<Master> masters = new HashSet<>();

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

    public Set<Master> getMasters() {
        return masters;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "name='" + name + '\'' +
                '}';
    }
}
