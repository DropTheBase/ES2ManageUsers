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
            //System.out.println("This ID is null!");
        }
        else if ( id < 0){
            //System.out.println("This ID is invalid!");
        } else {
            //System.out.println("ID Valid!");
        }
        return id;
    }

    public void setId(Integer id) throws InvalidException, NoException {
        if (id == null){
            throw new NoException();
        }
        else if (id < 0){
            throw new InvalidException();
        }
        this.id = id;
    }

    public String getEmail() {
        if (email == null){
            //System.out.println("This Email is null!");
        }
        else if (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")){
            //System.out.println("This Email is Invalid!");
        } else {
            //System.out.println("This Email is Valid!");
        }
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

    public String getPassword() {
        if (password == null){
            //System.out.println("This Password is Null!");
        }
        else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")){
            //System.out.println("This Password is Invalid!");
        } else {
            //System.out.println("This Password is Valid!");
        }
        return password;
    }

    public void setPassword(String password) throws NoException, InvalidException {
        if (password == null){
            throw new NoException();
        }
        else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")){
            throw new InvalidException();
        }
        this.password = password;
    }

    public String getToken() {
        if (token == null ){
            //System.out.println("This Token is Null!");
        }
        else if (!token.matches("^[a-zA-Z0-9]{10,30}$")){
            //System.out.println("This Token is Invalid!");
        }
        return token;
    }

    public void setToken(String token) throws NoException, InvalidException {
        if (token == null ){
            throw new NoException();
        }
        else if (!token.matches("^[a-zA-Z0-9]{10,30}$")){
            throw new InvalidException();
        }
        this.token = token;
    }
}