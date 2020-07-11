package com;
import Exception.*;
import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import java.sql.Timestamp;
import java.util.List;

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














































/* CODIGO ANTIGO

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


    public boolean equals(User user){

        return this.id == user.getId()&& this.first_name.equals(user.getFirst_name()) && this.last_name.equals(user.getLast_name()) && this.avatar.equals(user.getAvatar()) && this.email.equals(user.getEmail());

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
 */