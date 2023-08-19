package com.SpecialCare.SpecialCare.models;

import java.util.Date;

public class Pet {

    private Long id;
    private String name;
    private String pet_tipe;
    private String birthday_date;
    private String age;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPet_tipe() {
        return pet_tipe;
    }

    public void setPet_tipe(String pet_tipe) {
        this.pet_tipe = pet_tipe;
    }

    public String getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(String birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
