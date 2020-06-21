package com;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API {

    public static String path = "https://reqres.in";

    /*------
    USERS
    ---------*/
    //listar utilizadores
    public static List<User> listUsers(){

        List<User> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?page=1");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        for(int i = 0; i< data.length();i++){
            result.add(User.fromJSON(data.getJSONObject(i)));
        }

        return result;
    }


    //Consulta de dados de um utilizador
    public static User userDetails(int id) {

        String listUsersJSON = MateRequest.executeGet(path + "/api/users/" + id);

        JSONObject json = new JSONObject(listUsersJSON);
        return User.fromJSON(json.getJSONObject("data"));
    }


    //criar utilizador
    public static boolean createUser(User user) throws IOException {
        JSONObject json = user.toJson();
        json.remove("id");
        String resultJson = MateRequest.executePost(path + "/api/users", json.toString());
        JSONObject rj = new JSONObject(resultJson);
        System.out.println(resultJson);
        return rj.has("id");

    }

    /*------
    RESOURCES
    ---------*/

    //consultar lista de recursos
    public static List<Resource> listResources(){

        List<Resource> result = new ArrayList<>();
        String listResourcesJSON = MateRequest.executeGet(path + "/api/unknown");

        JSONObject json = new JSONObject(listResourcesJSON);
        JSONArray data = json.getJSONArray("data");

        for(int i = 0; i< data.length();i++){
            result.add(Resource.fromJSON(data.getJSONObject(i)));
        }

        return result;
    }


    //consultar um recurso

    public static Resource resourceDetails(int id) {

        String listResourceJSON = MateRequest.executeGet(path + "/api/unknown/" + id);

        JSONObject json = new JSONObject(listResourceJSON);
        return Resource.fromJSON(json.getJSONObject("data"));
    }

    //autenticar user
    public static boolean login(String email, String password){
        JSONObject object = new JSONObject();
        object.put("email", email);
        object.put("password", password);
        System.out.println(object.toString());



        try{
            String resultJSON = MateRequest.executePost(path + "/api/login",object.toString());
            JSONObject json = new JSONObject(resultJSON);
            return json.has("token");
        }catch (Exception ex) {
            return false;
        }
    }

    public static int register(String email, String password){
        JSONObject object = new JSONObject();
        object.put("email", email);
        object.put("password", password);
        System.out.println(object.toString());



        try{
            String resultJSON = MateRequest.executePost(path + "/api/register",object.toString());
            JSONObject json = new JSONObject(resultJSON);
            return json.getInt("id");
        }catch (Exception ex) {
            return 0;
        }
    }

    public static List<User> delayPublicUsers(){

        List<User> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?delay=3");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        for(int i = 0; i< data.length();i++){
            result.add(User.fromJSON(data.getJSONObject(i)));
        }

        return result;
    }

}
