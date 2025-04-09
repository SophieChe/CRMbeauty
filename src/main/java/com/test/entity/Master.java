package com.test.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "masters")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "surname is required field")
    private String surname;

    @Column(name = "level")
    private String masterLevel;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "phone")
    @Pattern(regexp = "\\+7-\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "please use pattern +7-XXX-XXX-XX-XX")
    private String phone;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "master_specialization", //промежуточная таблица
            joinColumns = @JoinColumn(name = "master_id"), //колонка для связи с мастером
            inverseJoinColumns = @JoinColumn(name = "specialization_id")//колонка для связи со специализацией
    )
    private Set<Specialization> specializations = new HashSet<>();

    @Transient
    private List<String> masterLevels = Arrays.asList("junior", "usual", "top");

    public Master() {

    }

    public Master(String name, String surname, String masterLevel, String specialization, String phone) {
        this.name = name;
        this.surname = surname;
        this.masterLevel = masterLevel;
        this.specialization = specialization;
        this.phone = phone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(String masterLevel) {
        this.masterLevel = masterLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<String> getMasterLevels() {
        return masterLevels;
    }

    public void setMasterLevels(List<String> masterLevels) {
        this.masterLevels = masterLevels;
    }


    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", masterLevel='" + masterLevel + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
