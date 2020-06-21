package com;


import org.json.JSONArray;
import org.json.JSONObject;
import sun.nio.cs.US_ASCII;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Stub {

    public JSONObject createUser(String name, String job){

        int id = 200;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         System.out.println(timestamp);

        JSONObject json = new JSONObject();

        json.put("name", name);
        json.put("job", job);
        json.put("id", id);
        json.put("createdAt", timestamp);


        System.out.println(json.toString());

        return json;


    }

    public JSONObject listUser(int id){

        JSONObject json = new JSONObject();

        if(id != 2){
            JSONObject jsonerror = new JSONObject();

            jsonerror.put("error", 404);


            System.out.println(jsonerror.toString());
            return jsonerror;
        }

        if(id==2) {

            String email = "janet.weaver@reqres.in";
            String first_name = "Janet";
            String last_name = "Weaver";
            String avatar = "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg";




            json.put("id", id);
            json.put("email", email);
            json.put("first_name", first_name);
            json.put("last_name", last_name);
            json.put("avatar", avatar);

        }



        System.out.println(json.toString());

        return json;

    }

    //stubs são estaticos, os mocks são dinamicos e variam o seu valor.

    public ArrayList<JSONObject> listAllUsers(){
        ArrayList<JSONObject> jsonArrays = new ArrayList<JSONObject>();


        User user= new User(1,"george.bluth@reqres.in","George","Bluth","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");


        User user2= new User(2,"janet.weaver@reqres.in","Janet","Weaver","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");


        User user3= new User(3,"emma.wong@reqres.in","Emma","Wong","https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");

        User user4= new User(4,"eve.holt@reqres.in","Eve","Holt","https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");

        User user5= new User(5,"charles.morris@reqres.in","Charles","Morris","https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");

        User user6= new User(6,"tracey.ramos@reqres.in","Tracey","Ramos","https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");

       jsonArrays.add(user.toJson());
       jsonArrays.add(user2.toJson());
       jsonArrays.add(user3.toJson());
       jsonArrays.add(user4.toJson());
       jsonArrays.add(user5.toJson());
       jsonArrays.add(user6.toJson());

        return jsonArrays;

    }


    public JSONObject registerUserToApp(String email, String password){

        JSONObject json = new JSONObject();



        if(password!=null && email!=null && password.equals("pistol") && email.equals("eve.holt@reqres.in")){
            json.put("id", 4);
            json.put("password", "pistol");
            json.put("email", "eve.holt@reqres.in");


        }else{
            json.put("id", -1);
            json.put("error", "Missing password or Email");
            json.put("status", 400);

        }


        System.out.println(json.toString());

        return json;

    }


    public JSONObject loginUser(String email,String password){

        JSONObject json = new JSONObject();

        User user = new User();

        User user3= new User(203,"eve.holt@reqres.in","andre","monteiro","image3.svg");

        String pass = "cityslicka";
        String mail = user3.getEmail();

        if(password.equals(pass) && email.equals(mail)){
            json.put("token", "ATK321");
            json.put("status", 200);
        }else{
            json.put("status", 400);
            System.out.println("Missing password/Email or password isn't correct.");
        }

        System.out.println(json.toString());
        return json;

    }


    public JSONObject listResource(int id){


        if(id != 2){
            JSONObject jsonerror = new JSONObject();

            jsonerror.put("error", 404);


            System.out.println(jsonerror.toString());
            return jsonerror;
        }


        String name = "fuchsia rose";
        int year = 2001;
        String color = "#C74375";
        String pantone_value = "17-2031";

        JSONObject json = new JSONObject();

        json.put("id", id);
        json.put("name", name);
        json.put("year", year);
        json.put("color", color);
        json.put("pantone_value",pantone_value);



        System.out.println(json.toString());

        return json;

    }


    public ArrayList<JSONObject> listAllResources(){
        ArrayList<Resource> listresources = new ArrayList<Resource>();

        Resource resource = new Resource(1,"cerulean",2000,"#98B2D1","15-4020");

        Resource resource2 = new Resource(2,"fuchsia rose",2001,"#C74375","17-2031");

        Resource resource3 = new Resource(3,"true red",2002,"#BF1932","19-1664");

        Resource resource4 = new Resource(4,"aqua sky",2003,"#7BC4C4","14-4811");

        Resource resource5 = new Resource(5,"tigerlily",2004,"#E2583E","17-1456");

        Resource resource6 = new Resource(6,"blue turquoise",2005,"#53B0AE","15-5217");


        listresources.add(resource);
        listresources.add(resource2);
        listresources.add(resource3);
        listresources.add(resource4);
        listresources.add(resource5);
        listresources.add(resource6);


        ArrayList<JSONObject> jsonArrays = new ArrayList<JSONObject>();
        JSONArray jsonArray = new JSONArray();



        for(int i = 0; i<listresources.size();i++) {

            JSONObject json = new JSONObject();

            json.put("id", listresources.get(i).getId());
            json.put("name", listresources.get(i).getName());
            json.put("year", listresources.get(i).getYear());
            json.put("color", listresources.get(i).getColor());
            json.put("pantone_value", listresources.get(i).getPantone_value());

            jsonArrays.add(json);
        }

        System.out.println(jsonArrays.toString());

        return jsonArrays;

    }


    public ArrayList<JSONObject> delayPublicUSers(int seconds) throws InterruptedException {

        if(seconds < 31){
            Thread.sleep(seconds*1000);
        }

        ArrayList<JSONObject> listusersdelay = listAllUsers();

        return listusersdelay;


    }

}
