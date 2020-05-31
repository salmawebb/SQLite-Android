package com.example.pets.entidades;

public class pet {
    private int id;
    private String name;
    private int age;
    private String owner;
    private String phone;

    public pet(int id, String name, int age, String owner, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.owner = owner;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

    public String getPhone() {
        return phone;
    }
}
