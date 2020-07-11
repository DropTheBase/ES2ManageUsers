package com;
import Exception.*;

import java.sql.Timestamp;


public class User {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String job;
    private Timestamp createdAt;

    public User(int id, String email, String first_name, String last_name, String avatar, String job, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.job = job;
        this.createdAt = createdAt;
    }
    public Timestamp getCreatedAt(){
        return createdAt;
    }
    public String getJob(){ return job;}
    
    public void setJob(String job) throws NoException, InvalidException {
        if (job == null){
            throw  new NoException();
        }
        else if (!job.matches("^[a-zA-Z]{2,25}$")){
            throw new InvalidException();
        }
        this.job = job;
    }
        
    public int getId() {
        return id;
    }
    public void setId(int id) throws NoException, InvalidException {
        if (id == 0){
            throw new NoException();
        }
        else if (id < 0){
            throw new InvalidException();
        }
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NoException, InvalidException {
        if (email == null){
            throw new NoException();
        }
        else if (!email.matches("^\\S+@\\S+$") || email.length() < 5){
            System.out.println("Invalid Email!");
            throw new InvalidException();
        }

        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) throws NoException, InvalidException {
        if (first_name == null){
            throw new NoException();
        }
        else if (!first_name.matches("^[a-zA-Z]{2,25}$")){
            throw new InvalidException();
        }
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setUltimo_nome(String last_name) throws NoException, InvalidException {
        if (last_name == null){
            throw new NoException();
        }
        else if (!last_name.matches("^[a-zA-Z]{2,25}$")){
            throw new InvalidException();
        }
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) throws NoException, InvalidException {
        if (avatar == null){
            throw new NoException();
        }
        else if (!avatar.matches("^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$")
                || avatar.length() < 10){
            throw new InvalidException();
        }

        this.avatar = avatar;
    }
}
