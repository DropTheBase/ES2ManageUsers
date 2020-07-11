package com;
import Exception.*;

public class Registry {
    private int id;
    private String email;
    private String password;
    private String token;

    public Registry(int id, String email, String password, String token) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidException, NoException {
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
        else if (!email.matches("^\\S+@\\S+$")|| email.length() < 5){
            throw new InvalidException();
        }

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) throws NoException, InvalidException {
        if (password == null){
            throw new NoException();
        }
        else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")
                || password.length() < 1){
            throw new InvalidException();
        }
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) throws NoException, InvalidException {
        if (token == null ){
            throw new NoException();
        }
        else if (!token.matches("^[a-zA-Z0-9]{30}$") || token.length() < 10){
            throw new InvalidException();
        }
        this.token = token;
    }
}
