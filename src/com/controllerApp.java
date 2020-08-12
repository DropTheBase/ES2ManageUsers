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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                    System.out.println("\nResponse 200 : Authenticated");
                    System.out.println("\tToken: " + stringjs);

                    token_list.put(email, stringjs);
                    return stringjs;
                }
            }

            if (status == HttpURLConnection.HTTP_BAD_REQUEST){

                if (email.isEmpty() && password.isEmpty()){
                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Missing Email and Password");
                    stringjs = "Missing Email and Password";
                }

                else if (email.isEmpty() && (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))){
                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Missing Email and Invalid Password");
                    stringjs = "Missing Email and Invalid Password";
                }

                else if (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})") &&
                        (password.isEmpty())){

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Invalid Email and Missing Password");
                    stringjs = "Invalid Email and Missing Password";
                }

                else if (email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})") &&
                        password.isEmpty()) {

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Missing Password");
                    stringjs = "Missing Password";
                }

                else if ((email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")) &&
                        (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))) {

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Invalid Password");
                    stringjs = "Invalid Password";
                }

                else if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$") && email.isEmpty()) {

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Missing Email");
                    stringjs = "Missing Email";
                }

                else if ((password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")) &&
                        (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,3})"))) {

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Invalid Email");
                    stringjs = "Invalid Email";
                }

                else if ((!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,3})"))  &&
                        (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))){

                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Invalid Email and Password");
                    stringjs = "Invalid Email and Password";
                }

                else {
                    System.out.println("\nResponse 400 : Error");
                    System.out.println("Bad Connection");
                    stringjs = "Bad Request";
                }

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
    public boolean createUser(String name, String job, Registry user, String token){
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

                String Stringinputjs = String.format("{\"name\" : \"%s\", \"job\" : \"%s\"}", name, job);

                try(OutputStream outstream = connection.getOutputStream()) {
                    byte[] input = Stringinputjs.getBytes("utf-8");
                    outstream.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();

                if(status == HttpURLConnection.HTTP_CREATED || name!=""){
                    try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                        String teste = new String();
                        String responseLine = null;
                        int i = 0;

                        while ((responseLine = br.readLine()) != null) {
                            teste = responseLine.trim();
                            i++;
                        }

                        if (name.isEmpty() && job.isEmpty()){
                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Missing Name and Job!");
                            return false;
                        }

                        else if (name.isEmpty() && (!job.matches("^[a-zA-Z]{2,25}$"))){
                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Missing Name and Invalid Job!");
                            return false;
                        }

                        else if (!name.matches("^[A-Za-z\\s]{2,25}[\\.]{0,1}[A-Za-z\\s]{0,25}$") && (job.isEmpty())){
                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Invalid Name and Missing Job!");
                            return false;
                        }

                        else if (name.matches("^[A-Za-z\\s]{2,25}[\\.]{0,1}[A-Za-z\\s]{0,25}$") &&
                                (job.isEmpty())){

                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Missing Job!");
                            return false;
                        }

                        else if (name.matches("^[A-Za-z\\s]{2,25}[\\.]{0,1}[A-Za-z\\s]{0,25}$") &&
                                (!job.matches("^[a-zA-Z]{2,25}$"))){

                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Invalid Job!");
                            return false;
                        }

                        else if (job.matches("^[a-zA-Z]{2,25}$") && (name.isEmpty())){

                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Missing Name!");
                            return false;
                        }

                        else if (job.matches("^[a-zA-Z]{2,25}$") &&
                                (!name.matches("^[A-Za-z\\s]{2,25}[\\.]{0,1}[A-Za-z\\s]{0,25}$"))){

                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Invalid Name!");
                            return false;
                        }

                        else if (!name.matches("^[A-Za-z\\s]{2,25}[\\.]{0,1}[A-Za-z\\s]{0,25}$") &&
                                (!job.matches("^[a-zA-Z]{2,25}$"))){

                            System.out.println("\nResponse 400 : Error");
                            System.out.println("Invalid Name and Job!");
                            return false;
                        }

                        else{
                            teste = teste.replace("{", "");
                            teste = teste.replace("}", "");
                            teste = teste.replace("\"", "");
                            teste = teste.replace("id:", "");
                            teste = teste.replace("CreatedAt:", "");
                            String[] data = teste.split(",");

                            System.out.println("\nResponse 201: User created");
                            System.out.println("\tName: " + name);
                            System.out.println("\tJob: " + job);
                            System.out.println("\tID: " + data[2]);
                            System.out.println("\tCreatedAt: " + LocalDateTime.now());

                            return true;
                        }
                    }
                }

                else if (status == HttpURLConnection.HTTP_BAD_REQUEST){

                    System.out.println("Response 400 : Error");
                    System.out.println("Fields incorret");
                    return false;
                }

                connection.disconnect();

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("You need make login!");
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

                if(status == HttpURLConnection.HTTP_OK){
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

                        System.out.println("\nResponse 200: User Registered");
                        System.out.println("\tID: " + data[0]);
                        System.out.println("\tToken: " + data[1]);

                        Registry newUser = new Registry(Integer.parseInt(data[0]), email, password, data[1]);
                        registry_list.add(newUser);
                        return newUser;
                    }
                }

                if (status == HttpURLConnection.HTTP_BAD_REQUEST){

                    if (email.isEmpty() && password.isEmpty()){
                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Missing Email and Password");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if (email.isEmpty() && (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))){
                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Missing Email and Invalid Password");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})") &&
                            (password.isEmpty())){

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Invalid Email and Missing Password");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if (email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})") &&
                            password.isEmpty()) {

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Missing Password");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if ((email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")) &&
                            (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))) {

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Invalid Password");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$") && email.isEmpty()) {

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Missing Email");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if ((password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")) &&
                            (!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,3})"))) {

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Invalid Email");

                        Registry newUser = null;
                        return newUser;
                    }

                    else if ((!email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,3})"))  &&
                            (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$"))){

                        System.out.println("\nResponse 400 : Error");
                        System.out.println("Invalid Email and Password");
                        Registry newUser = null;
                        return newUser;
                    }

                    System.out.println("\nResponse 400: Error");
                    System.out.println("Email and Password corrects, but exist any problem");
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
        else{
            System.out.println("\nYou need make login!");
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
        else{
            System.out.println("You need make login!");
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

                    System.out.println("\nResponse 200: User Details");
                    System.out.println("\tID: " + id_user);
                    System.out.println("\tEmail: " + email);
                    System.out.println("\tFirst Name: " + first_name);
                    System.out.println("\tLast Name: " + last_name);
                    System.out.println("\tAvatar: " + avatar);

                    User users = new User(id_user, first_name, last_name, email, avatar, job, createdAt);
                    return users;
                }

                if (status == HttpURLConnection.HTTP_NOT_FOUND){
                    System.out.println("\nResponse 404: {}");
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
        else{
            System.out.println("You need make login!");
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

                    System.out.println("\nResponse 200: Resource Details");
                    System.out.println("\tID: " + id_resource);
                    System.out.println("\tName: " + name);
                    System.out.println("\tYear: " + year);
                    System.out.println("\tColor: " + color);
                    System.out.println("\tPantone value: " + pantone_value + "\n");

                    Resource resource = new Resource(id_resource, name, Integer.parseInt(year), color, pantone_value);
                    return resource;
                }

                if (status == HttpURLConnection.HTTP_NOT_FOUND){
                    System.out.println("\nResponse 404: {}");
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
        else{
            System.out.println("You need make login!");
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
                        System.out.println("\tPantone Value: " + pantone_value + "\n");

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
        else{
            System.out.println("You need make login!");
        }
        return resources_list;
    }
}
