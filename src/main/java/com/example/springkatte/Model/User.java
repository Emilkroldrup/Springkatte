package com.example.springkatte.Model;

public class User {

    private int Id;
    private String Name;
    private String Email;
    private String Password;

    private String Role;

    public User(){

    }

    public User(int id, String name, String email, String password,String role){
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Role = role;
    }

    public User( String name, String email, String password){
        this.Name = name;
        this.Email = email;
        this.Password = password;
    }

    public User( String name, String email, String password, String role){
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getRole(){
        return Role;
    }

    public void setRole(String role){
        Role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
