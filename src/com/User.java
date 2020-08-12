package com;
import Exception.*;

import java.sql.Timestamp;


public class User {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String job;
    private Timestamp createdAt;

    public User(Integer id, String email, String first_name, String last_name, String avatar, String job, Timestamp createdAt) {
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

    public String getJob(){
        if(job==null){
            //System.out.println("Your JOB is NULL");
        }
        else if (!job.matches("^[a-zA-Z]{2,25}$")){
            //System.out.println("Your JOB is INCORRECT");
        }
        //System.out.println("Your JOB is CORRECT");
        return job;
    }
    
    public void setJob(String job) throws NoException, InvalidException {
        if (job == null){
            throw  new NoException();
        }
        else if (!job.matches("^[a-zA-Z]{2,25}$")){
            throw new InvalidException();
        }
        this.job = job;
    }
        
    public Integer getId() {
        if(id==null){
            //System.out.println("Your ID is NULL");
        }
        else if (id < 0){
            //System.out.println("Your ID is invalid!");
        }
        //System.out.println("Your ID is CORRECT");
        return id;
    }

    public void setId(Integer id) throws NoException, InvalidException {
        if (id == null){
            throw new NoException();
        }
        else if (id < 0){
            throw new InvalidException();
        }
        this.id = id;
    }

    public String getEmail() {
        if(email==null){
            //System.out.println("Your EMAIL is NULL");
        }
        else if (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")){
            //System.out.println("This Email is Invalid!");
        }
        //System.out.println("Your EMAIL is CORRECT");
        return email;
    }

    public void setEmail(String email) throws NoException, InvalidException {
        if (email == null){
            throw new NoException();

        }
        else if (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")){
            throw new InvalidException();
        }
        this.email = email;
    }

    public String getFirst_name() {
        if(first_name==null){
            //System.out.println("Your FIRST NAME is NULL");
        }
        else if (!first_name.matches("^[a-zA-Z]{2,25}$")){
            //System.out.println("Your FIRST NAME is INCORRECT");
        }
        //System.out.println("Your FIRST_NAME is CORRECT");
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
        if(last_name==null){
            //System.out.println("Your LAST NAME is NULL");
        }
        else if (!last_name.matches("^[a-zA-Z]{2,25}$")){
            //System.out.println("Your LAST NAME is INCORRECT");
        }
        //System.out.println("Your LAST NAME is CORRECT");
        return last_name;
    }

    public void setLast_name(String last_name) throws NoException, InvalidException {
        if (last_name == null){
            throw new NoException();
        }
        else if (!last_name.matches("^[a-zA-Z]{2,25}$")){
            throw new InvalidException();
        }
        this.last_name = last_name;
    }

    public String getAvatar() {
        if(avatar==null){
            //System.out.println("Your AVATAR is NULL");
        }
        else if (!avatar.matches("^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$")){
            //System.out.println("Your AVATAR is INCORRECT");
        }
        //System.out.println("Your AVATAR is CORRECT");
        return avatar;
    }

    public void setAvatar(String avatar) throws NoException, InvalidException {
        if (avatar == null){
            throw new NoException();
        }
        else if (!avatar.matches("^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$")){
            throw new InvalidException();
        }
        this.avatar = avatar;
    }
}
