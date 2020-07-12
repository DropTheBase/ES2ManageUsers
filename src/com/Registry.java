package com;
import Exception.*;

public class Registry {
    private Integer id;
    private String email;
    private String password;
    private String token;

    public Registry(Integer id, String email, String password, String token) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public Integer getId() {
        if (id == null){
            System.out.println("This ID is null!");
        }
        else if ( id < 0){
            System.out.println("This ID is invalid!");
        } else {
            System.out.println("ID Valid!");
        }
        return id;
    }

    public void setId(Integer id) throws InvalidException, NoException {
        if (id == null){
            System.out.println("This ID is null!");
            throw new NoException();
        }
        else if ( id < 0){
            System.out.println("This ID is invalid!");
            throw new InvalidException();
        }
        else {
            System.out.println("ID Valid!");}
        this.id = id;
    }

    public String getEmail() {
        if (email == null){
            System.out.println("This Email is null!");
        }
        else if (!email.matches("^\\S+@\\S+$")|| email.length() < 5 || email.length() > 20){
            System.out.println("This Email is Invalid!");
        } else {
            System.out.println("This Email is Valid!");
        }
        return email;
    }

    public void setEmail(String email) throws NoException, InvalidException {
        if (email == null){
            System.out.println("This Email is null!");
            throw new NoException();
        }
        else if (!email.matches("^\\S+@\\S+$")|| email.length() < 5 || email.length() > 20){
            System.out.println("This Email is Invalid!");
            throw new InvalidException();
        } else {
            System.out.println("This Email is Valid!");
        }

        this.email = email;
    }

    public String getPassword() {
        if (password == null){
            System.out.println("This Password is Null!");
        }
        else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")
                || password.length() < 3 ){
            System.out.println("This Password is Invalid!");
        } else {
            System.out.println("This Password is Valid!");
        }
        return password;
    }

    public void setPassword(String password) throws NoException, InvalidException {
        if (password == null){
            System.out.println("This Password is Null!");
            throw new NoException();
        }
        else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")
                || password.length() < 3 ){
            System.out.println("This Password is Invalid!");
            throw new InvalidException();
        } else {
            System.out.println("This Password is Valid!");
        }
        this.password = password;
    }

    public String getToken() {
        if (token == null ){
            System.out.println("This Token is Null!");
        }
        else if (!token.matches("^[a-zA-Z0-9]{10,30}$")){
            System.out.println("This Token is Invalid!");
        }
        return token;
    }

    public void setToken(String token) throws NoException, InvalidException {
        if (token == null ){
            System.out.println("This Token is Null!");
            throw new NoException();
        }
        else if (!token.matches("^[a-zA-Z0-9]{10,30}$")){
            System.out.println("This Token is Invalid!");
            throw new InvalidException();
        }
        this.token = token;
    }
}