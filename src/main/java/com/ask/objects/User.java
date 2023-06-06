package com.ask.objects;

public class User {
    private String id;

    private String password;

    private String email;

    public User(){}

    public User(String id, String password){
        this.id=id;
        this.password=password;
    }

    public User(String id, String password, String email){
        this.id=id;
        this.password=password;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


}
