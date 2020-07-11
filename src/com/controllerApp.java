package com;

import com.Registry;
import com.Resource;
import com.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import java.util.HashMap;
import java.util.Scanner;

public class controllerApp {


    ArrayList<User> users_list = new ArrayList<>();
    ArrayList<Resource> resources_list = new ArrayList<>();
    ArrayList<Registry> registry_list = new ArrayList<>();
    HashMap<String, String> token_list = new HashMap<>();

    // post login-------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public String loginUser(String email, String password){
        URL url = null;
        String stringjs = "";

        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            String Stringinputjs = String.format("{\"email\" : \"%s\", \"password\" : \"%s\"}", email, password);

            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = Stringinputjs.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                try(BufferedReader bufferreader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    int i = 0;
                    while ((responseLine = bufferreader.readLine()) != null) {
                        stringjs = responseLine.trim();
                        i++;
                    }

                    stringjs = stringjs.replace("{", "");
                    stringjs = stringjs.replace("}", "");
                    stringjs = stringjs.replace("\"", "");
                    stringjs = stringjs.replace("token:", "");

                    System.out.println("Response 200 : Authenticated");
                    System.out.println("\tToken: " + stringjs);

                    token_list.put(email, stringjs);
                    return stringjs;
                }
            }

            if (status == HttpURLConnection.HTTP_BAD_REQUEST){
                System.out.println("Response 400 : Error");
                System.out.println("Fields incorret");
                stringjs = "Bad Request";
                return stringjs;
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringjs;
    }

    //create User-------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean createUser(User newUser, Registry user, String token){
        if(user.getToken().equals(token)){
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

                String Stringinputjs = String.format("{\"first_name\" : \"%s\", \"last_name\" : \"%s\", \"job\" : \"%s\", \"id\" : \"%d\", \"createdAt\" : \"%s\"}",
                        newUser.getFirst_name(),newUser.getLast_name(), newUser.getJob(), newUser.getId(), newUser.getCreatedAt());

                try(OutputStream outstream = connection.getOutputStream()) {
                    byte[] input = Stringinputjs.getBytes("utf-8");
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
                        users_list.add(newUser);

                        System.out.println("Response 201: User created\n");

                        System.out.println("\tName: " + newUser.getId() + " " + newUser.getLast_name());
                        System.out.println("\tJob: " + newUser.getJob());
                        System.out.println("\tID: " + newUser.getId());
                        System.out.println("\tCreatedAt: " + newUser.getCreatedAt());

                        return true;
                    }
                }

                connection.disconnect();

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Registry User-----------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public Registry registryuser(String email, String password, Registry user, String token){
        URL url = null;
        String inline = "";

        if(user.getToken().equals(token)){
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

                try(OutputStream outputstr = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    outputstr.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();

                if(status == HttpURLConnection.HTTP_OK){ //ID 1
                    try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                        String teste = new String();
                        String responseLine = null;

                        while ((responseLine = br.readLine()) != null) {
                            teste = responseLine.trim();
                        }

                        teste = teste.replace("{", "");
                        teste = teste.replace("}", "");
                        teste = teste.replace("\"", "");
                        teste = teste.replace("id:", "");
                        teste = teste.replace("token:", "");
                        String[] data = teste.split(",");

                        System.out.println("Response 200: User Registered");
                        System.out.println("\tID: " + data[0]);
                        System.out.println("\tToken: " + data[1]);

                        Registry newUser = new Registry(Integer.parseInt(data[0]), email, password, data[1]);
                        registry_list.add(newUser);
                        return newUser;
                    }
                }

                if (status == HttpURLConnection.HTTP_BAD_REQUEST){
                    System.out.println("Response 400: Error");
                    Registry newUser = null;
                    return newUser;
                }

                connection.disconnect();

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Registry newUser = null;
        return newUser;
    }
    // get User  -------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<User> listingUsers(Registry user, String token){
        if(user.getToken().equals(token)){
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
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuffer content = new StringBuffer();

                    Scanner scanner = new Scanner(url.openStream());

                    while(scanner.hasNext())
                    {
                        inline+=scanner.nextLine();
                    }

                    in.close();

                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(inline);
                    JSONArray arrayjs = (JSONArray) obj.get("data");

                    System.out.println("\nResponse: 200: List Users");
                    for(int i=0;i<arrayjs.size();i++)
                    {
                        JSONObject objdata = (JSONObject)arrayjs.get(i);
                        int id = (int) (long) objdata.get("id");
                        String email = (String) objdata.get("email");
                        String first_name = (String) objdata.get("first_name");
                        String last_name = (String) objdata.get("last_name");
                        String avatar = (String) objdata.get("avatar");
                        String job = (String) objdata.get("job");
                        Timestamp createdAt = (Timestamp) objdata.get("createdAt");

                        System.out.println("\tID: " + id);
                        System.out.println("\tE-mail: " + email);
                        System.out.println("\tPrimeiro Nome: " + first_name);
                        System.out.println("\tÚltimo Nome: " + last_name);
                        System.out.println("\tAvatar: " + avatar + "\n");

                        User users = new User(id, first_name, last_name, email, avatar, job, createdAt);
                        users_list.add(users);
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
        }
        return users_list;
    }

    // get User details ------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public User consultingUser(Integer id, Registry user, String token){
        if(user.getToken().equals(token)){
            URL url = null;
            String inline = "";
            try {
                url = new URL("https://reqres.in/api/users/" + id);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setInstanceFollowRedirects(false);
                connection.connect();

                int status = connection.getResponseCode();

                if(status == HttpURLConnection.HTTP_OK){
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuffer content = new StringBuffer();

                    Scanner sc = new Scanner(url.openStream());

                    while(sc.hasNext())
                    {
                        inline+=sc.nextLine();
                    }

                    in.close();

                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(inline);
                    JSONObject objdata = (JSONObject) obj.get("data");

                    int id_user = (int) (long) objdata.get("id");
                    String email = (String) objdata.get("email");
                    String first_name = (String) objdata.get("first_name");
                    String last_name = (String) objdata.get("last_name");
                    String avatar = (String) objdata.get("avatar");
                    String job = (String) objdata.get("job");
                    Timestamp createdAt = (Timestamp) objdata.get("createdAT");

                    System.out.println("Response 200: User Details");
                    System.out.println("\tID: " + id_user);
                    System.out.println("\tEmail: " + email);
                    System.out.println("\tFirst Name: " + first_name);
                    System.out.println("\tLast Name: " + last_name);
                    System.out.println("\tAvatar: " + avatar);

                    User users = new User(id_user, first_name, last_name, email, avatar, job, createdAt);
                    return users;
                }

                if (status == HttpURLConnection.HTTP_NOT_FOUND){
                    System.out.println("Response 404: {}");
                    User users = null;
                    return users;
                }

                connection.disconnect();

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }

        User users = null;
        return users;
    }

    // get Resources details -------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public Resource consultingResource(Integer id, Registry user, String token){
        if(user.getToken().equals(token)){
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
                    BufferedReader buffread = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuffer content = new StringBuffer();
                    Scanner scanner = new Scanner(url.openStream());

                    while(scanner.hasNext())
                    {
                        inline+=scanner.nextLine();
                    }

                    buffread.close();

                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(inline);
                    JSONObject objjs = (JSONObject) obj.get("data");

                    int id_resource = (int) (long) objjs.get("id");
                    String name = (String) objjs.get("name");
                    String year = String.valueOf(objjs.get("year"));
                    String color = (String) objjs.get("color");
                    String pantone_value = (String) objjs.get("pantone_value");

                    System.out.println("Response 200: Resource Details");
                    System.out.println("\tID: " + id_resource);
                    System.out.println("\tNome: " + name);
                    System.out.println("\tAno: " + year);
                    System.out.println("\tCódigo de Côr: " + color);
                    System.out.println("\tCódigo Pantone: " + pantone_value + "\n");

                    Resource resource = new Resource(id_resource, name, Integer.parseInt(year), color, pantone_value);
                    return resource;
                }

                if (status == HttpURLConnection.HTTP_NOT_FOUND){ //ID 5
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
        }

        Resource resource = null;
        return resource;
    }


    // get Resources ---------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<Resource> listingResources (Registry user, String token){
        if(user.getToken().equals(token)){
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
                    BufferedReader buffreader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuffer content = new StringBuffer();

                    Scanner scanner = new Scanner(url.openStream());

                    while(scanner.hasNext())
                    {
                        inline+=scanner.nextLine();
                    }

                    buffreader.close();

                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(inline);
                    JSONArray arrayjs = (JSONArray) obj.get("data");

                    System.out.println("\nResponse 200: Resources List");

                    for(int i=0;i<arrayjs.size();i++)
                    {
                        JSONObject objdata = (JSONObject)arrayjs.get(i);
                        int id = (int) (long) objdata.get("id");
                        String name = (String) objdata.get("name");
                        String year = String.valueOf(objdata.get("year"));
                        String color = (String) objdata.get("color");
                        String pantone_value = (String) objdata.get("pantone_value");

                        System.out.println("\tID: " + id);
                        System.out.println("\tName: " + name);
                        System.out.println("\tYear: " + year);
                        System.out.println("\tColor: " + color);
                        System.out.println("\tPaantone Value: " + pantone_value + "\n");

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
        }

        return resources_list;
    }
}
