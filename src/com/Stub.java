package com;

import java.util.*;

import Exception.*;

public class Stub {

    ArrayList<User> users_list = new ArrayList<>();
    ArrayList<Resource> resources_list = new ArrayList<>();
    ArrayList<Registry> registry_list = new ArrayList<>();
    HashMap<Integer, String> token_list = new HashMap<>();

    //Add Users
    public void createUser(User user) throws NoException, RepeatedException{
        if (users_list == null) {
            System.out.println("\nList doesn't exists!\n");
            throw new NoException();
        }
        else if (user.getId() == 0) {
            throw new NoException();
        }
        else if (user.getFirst_name() == null || user.getLast_name() == null || user.getEmail() == null || user.getAvatar() == null) {
            throw new NoException();
        }


        for (int i = 0; i < users_list.size(); i++) {
            int obj = user.getId();
            if (users_list.get(i).getId() == (obj) || users_list.get(i).getEmail().equals(user.getEmail())) {
                System.out.println("\nUser already exists!\n");
                throw new RepeatedException();
            }
        }
        users_list.add(user);
    }

    // add Resources

    public void addResource(Resource resource) throws NoException, RepeatedException{
        if (resources_list == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }
        else if (resource.getId() == null || resource.getName() == null || resource.getYear() == null || resource.getColor() == null || resource.getPantone_value() == null) {
            throw new NoException();
        }

        for (int i = 0; i < resources_list.size(); i++) {
            if (resources_list.get(i).getId().equals(resource.getId()) || resources_list.get(i).getName().equals(resource.getName())) {
                System.out.println("\nResource already exists!\n");
                throw new RepeatedException();
            }
        }
        resources_list.add(resource);

    }

    // Users list

    public ArrayList<User> listingUsers() throws NoException {
        if (users_list == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }

        else if (users_list.size() < 1) {
            System.out.println("\nThe list don't have any user!\n");
            return null;
        }

        else {
            System.out.println("\nThe list is:\n");
            return users_list;
        }
    }

    // User detail

    public User consultingUser(Integer id) throws NoException, InvalidException {
        if (users_list == null || id == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }

        else if (id < 0){
            throw new InvalidException();
        }

        for (int i = 0; i < users_list.size(); i++) {
            if (users_list.get(i).getId() == (id)){
                System.out.println("\nUser : \n");
                return users_list.get(i);
            }
        }

        System.out.println("\nUser doesn't exists in the list!\n");
        return null;
    }

    // Resources list

    public ArrayList<Resource> listingResources() throws NoException {
        if (resources_list == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }

        else if (resources_list.size() < 1) {
            System.out.println("\nThe list don't contain any Resources!\n");
            return null;
        }

        else {
            System.out.println("\nThe list resources is:\n");
            return resources_list;
        }
    }

    // resources details

    public Resource consultingResource(Integer id) throws NoException, InvalidException {
        if (resources_list == null || id == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }

        else if (id < 0){
            throw new InvalidException();
        }

        for (int i = 0; i < resources_list.size(); i++) {
            if (resources_list.get(i).getId().equals(id)){
                System.out.println("\nResource is :\n");
                return resources_list.get(i);
            }
        }

        System.out.println("\nResource doesn't exists!\n");
        return null;
    }


    // Registry User
    public Registry registryuser(String email, String password) throws NoException, RepeatedException, InvalidException{
        if (token_list == null || registry_list == null || users_list == null || email == null || password == null) {
            System.out.println("\nLIst doesn't exists!\n");
            throw new NoException();
        }
        else if (email == null && password == null || !email.matches("^\\S+@\\S+$") || email.length() < 5 || !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")){
            throw  new InvalidException();
        }

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase(Locale.ROOT);
        String digits = "0123456789";
        String join = upper + lower + digits;
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            builder.append(join.charAt(random.nextInt(join.length())));
        }
        String token = builder.toString();

        for (int i = 0; i < users_list.size(); i++) {
            if (users_list.get(i).getEmail().equals(email)){
                if (users_list.get(i).getId() == 0) {
                    throw new NoException();
                }
                else if (token == null) {
                    throw new NoException();
                }else if (!token.matches("^[a-zA-Z0-9]{30}$") || token.length() < 10){
                    throw new InvalidException();
                }

                for (int j = 0; j < registry_list.size(); j++) {
                    if (registry_list.get(j).getId() == (users_list.get(i).getId()) || registry_list.get(j).getEmail().equals(users_list.get(i).getEmail())) {
                        System.out.println("\nUser already registered!\n");
                        throw new RepeatedException();
                    }
                }

                Registry userRegistry = new Registry(users_list.get(i).getId(), email, password, token);
                registry_list.add(userRegistry);
                token_list.put(userRegistry.getId(), userRegistry.getToken());
                System.out.println("\nUser successfully registered!");

                return userRegistry;
            }
        }

        System.out.println("\nUser doesn't exist!\n");
        return null;
    }

    // Login User
    public String loginUser(String email, String password) throws NoException, InvalidException {
        if (token_list == null || registry_list == null || email == null || password == null) {
            System.out.println("\nList doesn't exist!\n");
            throw new NoException();
        } else if (email == null && password == null || !email.matches("^\\S+@\\S+$") || email.length() < 5 || !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,30}$")){
            throw new InvalidException();
        }


        Boolean exists = Boolean.FALSE;
        for (int i = 0; i < registry_list.size(); i++) {
            if (registry_list.get(i).getEmail().equals(email)){
                exists = Boolean.TRUE;
                if (registry_list.get(i).getPassword().equals(password)) {

                    for (Map.Entry entry : token_list.entrySet()) {
                        if(entry.getKey().equals(registry_list.get(i).getId())){
                            if(entry.getValue() == registry_list.get(i).getToken()){
                                System.out.println("\nAuthenticated!\n");
                                return registry_list.get(i).getToken();
                            }
                            else {
                                System.out.println("\nWrong token!\n");
                                throw new InvalidException();
                            }
                        }
                    }
                }
                else {
                    System.out.println("\nWrong password!\n");
                }
            }
        }
        if (exists == Boolean.FALSE) {
            System.out.println("\nUser is not registered!\n");
            throw new NoException();
        }
        return null;
    }

}




























































/*
CODIGO ANTIGO



 public JSONObject createUser(String name, String job){
        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher_name = pattern.matcher(name);
        Matcher matcher_job = pattern.matcher(job);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int id = 200;

        JSONObject json = new JSONObject();

        json.put("id", id);
        json.put("name", name);
        json.put("job", job);
        json.put("createdAt", timestamp);

        if(name != "" && job != "") {
            if (matcher_name.find() && matcher_job.find()) {

                System.out.println("status:" + " 400");
                System.out.println("Name and job can't contain numbers.");

            } else if(matcher_name.find()) {
                System.out.println("status:" + " 400");
                System.out.println("Name can't contain numbers.");

            } else if(matcher_job.find()) {
                System.out.println("status:" + " 400");
                System.out.println("Job can't contain numbers.");

            } else {
                System.out.println("status:" + " 201");
                System.out.println("User with job was Created.");

                System.out.println(json.toString());
            }
        }

        else if(name != "" && job == "") {
            if (matcher_name.find()) {

                System.out.println("status:" + " 400");
                System.out.println("Name can't contain numbers.");

            }else {
                System.out.println("status:" + " 201");
                System.out.println("User without job was Created.");

                System.out.println(json.toString());
            }
        }
        else if (name == "" && (job == "" || job != "")){
            System.out.println("status:"+ " 400");
            System.out.println("Missing name in User.");
        }

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
        }

        else if (password == "" && email== ""){
            json.put("status", 400);
            System.out.println("Missing email and password.");
        }

        else if (password == "" && email != ""){
            json.put("status", 400);
            System.out.println("Missing password.");
        }

        else if (password != ""  && email == ""){
            json.put("status", 400);
            System.out.println("Missing Email.");
        }

        else if (password.equals(pass) && (! email.equals(mail))){
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()==true){
                json.put("status", 400);
                System.out.println("Email with correct format, but incorrect.");
            }
            else {
                json.put("status", 400);
                System.out.println("Email with incorrect format.");
            }
        }

        else if ((! password.equals(pass)) && email.equals(mail)){
            json.put("status", 400);
            System.out.println("Password incorrect");
        }

        else if (password != "" && email != ""){
            json.put("status", 400);
            System.out.println("Invalid Email and Password.");
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
 */