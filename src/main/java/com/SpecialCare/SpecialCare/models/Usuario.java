package com.SpecialCare.SpecialCare.models;

public class Usuario {

    private Long id;
    private String First_Name;
    private String Second_Name;
    private String Lastname;
    private String Second_Lastname;
    private String Email;
    private String Password;
    private String Phone_Number;

    public String getFirst_Name() {
        return First_Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getSecond_Name() {
        return Second_Name;
    }

    public void setSecond_Name(String second_Name) {
        Second_Name = second_Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getSecond_Lastname() {
        return Second_Lastname;
    }

    public void setSecond_Lastname(String second_Lastname) {
        Second_Lastname = second_Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }
}
