package com.example.springkatte.pets.domain;

public class Pets {

    private int id;
    private int age;
    private int ownerId;
    private String name;
    private String race;

    public Pets(){
    }

    public Pets(int id, int age, int ownerId, String name, String race) {
        this.id = id;
        this.age = age;
        this.ownerId = ownerId;
        this.name = name;
        this.race = race;
    }
    public Pets( int age, int ownerId, String name, String race) {
        this.age = age;
        this.ownerId = ownerId;
        this.name = name;
        this.race = race;
    }
    public Pets( int age, String name, String race) {
        this.age = age;
        this.name = name;
        this.race = race;
    }

    public Pets( String name, int age, String race) {
        this.name = name;
        this.age = age;

        this.race = race;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int owner) {
        this.ownerId = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Pets{" +
                "id=" + id +
                ", age=" + age +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
