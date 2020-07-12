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
            System.out.println("Your JOB is NULL");
            return job;
        }else if (job.length()<4 ||job.length()>35){
            System.out.println("Your JOB is INCORRECT");
            return job;
        }
        System.out.println("Your JOB is CORRECT");
        return job;
       }
    
    public void setJob(String job) throws NoException, InvalidException {
        if (job == null){
            System.out.println("Your JOB is NULL");
            throw  new NoException();
        }
        else if (!job.matches("^[a-zA-Z]{2,25}$")|| job.length()<4 || job.length()>30){
            System.out.println("INVALID JOB");
            throw new InvalidException();
        }
        System.out.println("CORRECT JOB");
        this.job = job;
    }
        
    public Integer getId() {
        if(id==null){
            System.out.println("Your ID is NULL");
        }else
            System.out.println("Your ID is CORRECT");
        return id;
    }
    public void setId(Integer id) throws NoException, InvalidException {
        if (id == null){
            System.out.println("Data is Null");
            throw new NoException();
        }
        else if (id < 0){
            System.out.println("Data is Negative");
            throw new InvalidException();
        }

        System.out.println("Data ID is CORRECT");
        this.id = id;
    }

    public String getEmail() {
        if(email==null){
            System.out.println("Your EMAIL is NULL");
        }else
            System.out.println("Your EMAIL is CORRECT");
        return email;
    }

    public void setEmail(String email) throws NoException, InvalidException {
        if (email == null){
            System.out.println("There is no data");
            throw new NoException();

        }
        else if (!email.matches("^\\S+@\\S+$") || email.length() < 5 || email.length() > 20){
            System.out.println("Invalid Email!");
            throw new InvalidException();
        }
        this.email = email;
        System.out.println("Success Email Introduced");
    }

    public String getFirst_name() {
        if(first_name==null){
            System.out.println("Your FIRST NAME is NULL");
            return first_name;
        }else if (first_name.length()<4 ||first_name.length()>10){
            System.out.println("Your FIRST NAME is INCORRECT");
            return first_name;
        }

        System.out.println("Your FIRST_NAME is CORRECT");
        return first_name;
    }

    public void setFirst_name(String first_name) throws NoException, InvalidException {
        if (first_name == null){
            System.out.println("Your FIRST NAME is NULL");
            throw new NoException();
        }

        else if (!first_name.matches("^[a-zA-Z]{2,25}$")||first_name.length() < 2||first_name.length() > 20){
            System.out.println("FIRST NAME is INVALID");
            throw new InvalidException();
        }


        System.out.println("Your FIRST NAME is CORRECT");
        this.first_name = first_name;
    }

    public String getLast_name() {
        if(last_name==null){
            System.out.println("Your LAST NAME is NULL");
            return last_name;
        }else if (last_name.length() < 4||last_name.length() > 20){
            System.out.println("Your LAST NAME is INCORRECT");
            return last_name;
        }
        System.out.println("Your LAST NAME is CORRECT");

        return last_name;
    }

    public void setLast_name(String last_name) throws NoException, InvalidException {
        if (last_name == null){
            System.out.println("Your LAST NAME is NULL");
            throw new NoException();
        }
        else if (!last_name.matches("^[a-zA-Z]{2,25}$")||last_name.length() < 2||last_name.length() > 20){
            System.out.println("LAST NAME INVALID");
            throw new InvalidException();
        }
        System.out.println("Your LAST NAME is VALID");
        this.last_name = last_name;
    }

    public String getAvatar() {
        if(avatar==null){
            System.out.println("Your AVATAR is NULL");
            return avatar;
        }else if (avatar.length() < 15||avatar.length() > 75){
            System.out.println("Your AVATAR is INCORRECT");
            return avatar;
        }

        System.out.println("Your AVATAR is CORRECT");

        return avatar;
    }

    public void setAvatar(String avatar) throws NoException, InvalidException {
        if (avatar == null){
            System.out.println("The AVATAR is NULL");
            throw new NoException();
        }
        else if (!avatar.matches("^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$")
                || avatar.length() < 10 || avatar.length() > 70){
            System.out.println("Invalid AVATAR");
            throw new InvalidException();
        }

        System.out.println("AVATAR is CORRECT");
        this.avatar = avatar;
    }
}
