package com;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API {
    ArrayList<User> users_list = new ArrayList<>();
    ArrayList<Resource> resources_list = new ArrayList<>();
    // Users list-------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<User> listingUsers(){
        URL url = null;
        String inline = "";
        try {
            url = new URL("https://reqres.in/api/users?page=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader bufferread = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer content = new StringBuffer();
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    inline+=sc.nextLine();
                }

                bufferread.close();

                JSONParser parser = new JSONParser();
                JSONObject obj = (org.json.simple.JSONObject) parser.parse(inline);
                JSONArray jsarray = (org.json.simple.JSONArray) obj.get("data");

                System.out.println("Response 200: List Users");

                for(int i=0;i<jsarray.size();i++)
                {
                    org.json.simple.JSONObject jsonobj_1 = (JSONObject)jsarray.get(i);
                    int id = (int) (long) jsonobj_1.get("id");
                    String email = (String) jsonobj_1.get("email");
                    String first_name = (String) jsonobj_1.get("first_name");
                    String last_name = (String) jsonobj_1.get("last_name");
                    String avatar = (String) jsonobj_1.get("avatar");
                    String job = (String) jsonobj_1.get("job");
                    Timestamp createdAt = (Timestamp) jsonobj_1.get("createdAT");

                    System.out.println("\tID: " + id);
                    System.out.println("\tFirst Name: " + first_name);
                    System.out.println("\tLast Name: " + last_name);
                    System.out.println("\tEmail: " + email);
                    System.out.println("\tAvatar: " + avatar);
                    System.out.println("\n");

                    User user = new User(id, first_name, last_name, email, avatar,job,createdAt);

                    users_list.add(user);

                }

                return users_list;

            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return users_list;
    }

    // User Detail------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public User consultingUser(Integer id){
        URL url = null;
        String inline = "";
        try {
            url = new URL("https://reqres.in/api/users/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setInstanceFollowRedirects(false);
            con.connect();

            int status = con.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader bufferreader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuffer content = new StringBuffer();

                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext())
                {
                    inline+=scanner.nextLine();
                }

                bufferreader.close();

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(inline);
                JSONObject jsobj = (JSONObject) obj.get("data");

                int id_user = (int) (long) jsobj.get("id");
                String email = (String) jsobj.get("email");
                String first_name = (String) jsobj.get("first_name");
                String last_name = (String) jsobj.get("last_name");
                String avatar = (String) jsobj.get("avatar");
                String job = (String) jsobj.get("job");
                Timestamp createdAt = (Timestamp) jsobj.get("createdAt");

                System.out.println("\nResponse 200: User detail \n");
                System.out.println("\tID: " + id_user);
                System.out.println("\tEmail: " + email);
                System.out.println("\tFirst Name: " + first_name);
                System.out.println("\tLast Name: " + last_name);
                System.out.println("\tAvatar: " + avatar);

                User user = new User(id_user, first_name, last_name, email, avatar, job, createdAt);
                return user;
            }

            if (status == HttpURLConnection.HTTP_NOT_FOUND){
                System.out.println("Response 404: {}");
                User user = null;
                return user;
            }

            con.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        User user = null;
        return user;
    }

    // Create User -----------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public void createUser(String name, String job){
        URL url = null;

        try {
            url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            String inputstr = String.format("{\"name\" : \"%s\", \"job\" : \"%s\"}", name, job);

            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = inputstr.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_CREATED){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String teste = new String();
                    String responseLine = null;
                    int i = 0;

                    while ((responseLine = br.readLine()) != null) {
                        teste = responseLine.trim();
                        i++;
                    }

                    teste = teste.replace("{", "");
                    teste = teste.replace("}", "");
                    teste = teste.replace("\"", "");
                    teste = teste.replace("id:", "");
                    teste = teste.replace("createdAt:", "");
                    String[] data = teste.split(",");
                    String createdAtreplace = data[3].replace("T", " ");
                    String createdAt = createdAtreplace.substring(0, 16);

                    System.out.println("\nResponse 201: User created\n");
                    System.out.println("\tName: " + name);
                    System.out.println("\tJob: " + job);
                    System.out.println("\tID: " + data[2]);
                    System.out.println("\tCreatedAt: " + createdAt);
                }
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Registry User ---------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public Registry registryuser(String email, String password){
        URL url = null;

        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            String jsonInputString = String.format("{\"email\" : \"%s\", \"password\" : \"%s\"}", email, password);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){ //ID 1
                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String teste = new String();
                    String responseLine = null;
                    int i = 0;

                    while ((responseLine = br.readLine()) != null) {
                        teste = responseLine.trim();
                        i++;
                    }

                    teste = teste.replace("{", "");
                    teste = teste.replace("}", "");
                    teste = teste.replace("\"", "");
                    teste = teste.replace("id:", "");
                    teste = teste.replace("token:", "");
                    String[] data = teste.split(",");

                    System.out.println("\nResponse 200: User registry\n");
                    System.out.println("\tID: " + data[0]);
                    System.out.println("\tToken: " + data[1]);

                    Registry user = new Registry(Integer.parseInt(data[0]), email, password, data[1]);
                    return user;
                }
            }

            if (status == HttpURLConnection.HTTP_BAD_REQUEST){ //ID 4
                System.out.println("Response 400: Error");
                Registry user = null;
                return user;
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Registry user = null;
        return user;
    }

    // Login User ------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public String loginUser(String email, String password){
        URL url = null;
        String inline = "";
        String teste = "";

        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            String jsonInputString = String.format("{\"email\" : \"%s\", \"password\" : \"%s\"}", email, password);

            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    int i = 0;
                    while ((responseLine = br.readLine()) != null) {
                        teste = responseLine.trim();
                        i++;
                    }

                    teste = teste.replace("{", "");
                    teste = teste.replace("}", "");
                    teste = teste.replace("\"", "");
                    teste = teste.replace("token:", "");

                    System.out.println("\n Response 200: Login Success \n");
                    System.out.println("\tToken: " + teste);

                    return teste;
                }
            }

            if (status == HttpURLConnection.HTTP_BAD_REQUEST){
                System.out.println("Response 400: Error");
                teste = "Bad Request";
                return teste;
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teste;
    }

    // Resources List --------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<Resource> listingResources(){
        URL url = null;
        String inline = "";
        try {
            url = new URL("https://reqres.in/api/unknown");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader buferreader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuffer content = new StringBuffer();

                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext())
                {
                    inline+=scanner.nextLine();
                }

                buferreader.close();

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(inline);
                JSONArray jsobj = (JSONArray) obj.get("data");

                System.out.println("Response 200: Resource List");

                for(int i=0;i<jsobj.size();i++)
                {
                    JSONObject jsobjget = (JSONObject)jsobj.get(i);
                    int id = (int) (long) jsobjget.get("id");
                    String name = (String) jsobjget.get("name");
                    String year = String.valueOf(jsobjget.get("year"));
                    String color = (String) jsobjget.get("color");
                    String pantone_value = (String) jsobjget.get("pantone_value");

                    System.out.println("\tID: " + id);
                    System.out.println("\tName: " + name);
                    System.out.println("\tYear: " + year);
                    System.out.println("\tColor: " + color);
                    System.out.println("\tPantone Value: " + pantone_value);
                    System.out.println("\n");

                    Resource resource = new Resource(id, name, Integer.parseInt(year), color, pantone_value);
                    resources_list.add(resource);
                }

                return  resources_list;

            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return resources_list;
    }

    // Resources Detail --------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public Resource consultingResource(Integer id){
        URL url = null;
        String inline = "";
        try {
            url = new URL("https://reqres.in/api/unknown/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader bufferread = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer content = new StringBuffer();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext())
                {
                    inline+=scanner.nextLine();
                }

                bufferread.close();

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(inline);
                JSONObject jsobj = (JSONObject) obj.get("data");

                int id_res = (int) (long) jsobj.get("id");
                String name = (String) jsobj.get("name");
                String year = String.valueOf(jsobj.get("year"));
                String color = (String) jsobj.get("color");
                String pantone_value = (String) jsobj.get("pantone_value");

                System.out.println("\nResponse 200: Resource detail \n");
                System.out.println("\tID: " + id_res);
                System.out.println("\tName: " + name);
                System.out.println("\tYear: " + year);
                System.out.println("\tColor: " + color);
                System.out.println("\tPantone value: " + pantone_value);

                Resource resource = new Resource(id_res, name, Integer.parseInt(year), color, pantone_value);
                return resource;
            }

            if (status == HttpURLConnection.HTTP_NOT_FOUND){
                System.out.println("Response 404: {}");
                Resource resource = null;
                return resource;
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Resource resource = null;
        return resource;
    }
}
