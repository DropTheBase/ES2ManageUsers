package com;

import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.util.List;

public class User {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public User() {
        this.id = 0;
        this.email = "";
        this.first_name = "";
        this.last_name = "";
        this.avatar = "";
    }

    public User(int id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public User(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.avatar = user.getAvatar();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    protected User clone() {
        return new User(this);
    }

    @Override
    public String toString() {
        return "id: " + this.id + " first_name: " + this.first_name + " last_name: " + this.last_name + " email: " + this.email + " avatar: " + this.avatar;
    }

    public JSONObject toJson (){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("first_name", this.first_name);
        json.put("last_name", this.last_name);
        json.put("email", this.email);
        json.put("avatar", this.avatar);

        return json;
    }

    public static void printListUsers(List<User> users){

        for(int i = 0; i< users.size();i++){
            System.out.println(users.get(i).toString());
        }

    }

    public static User fromJSON(JSONObject json){
        User user = new User();
        user.setId(json.optInt("id",0));
        user.setEmail(json.optString("email",""));
        user.setFirst_name(json.optString("first_name",""));
        user.setLast_name(json.optString("last_name",""));
        user.setAvatar(json.optString("avatar",""));

        return user;
    }
}
