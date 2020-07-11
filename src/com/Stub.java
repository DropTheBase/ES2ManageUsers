package com;
import Exception.*;

import java.util.*;


public class Stub implements FE {
    ArrayList<User> users_list = new ArrayList<>();
    ArrayList<Resource> resources_list = new ArrayList<>();
    ArrayList<Registry> registry_list = new ArrayList<>();
    HashMap<Integer, String> token_list = new HashMap<>();

    //Add Users
    public void createUser(User user) throws NoException, RepetedException{
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
                throw new RepetedException();
            }
        }
        users_list.add(user);
    }

    // add Resources

    public void addResource(Resource resource) throws NoException, RepetedException{
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
                throw new RepetedException();
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
    public Registry registryuser(String email, String password) throws NoException, RepetedException, InvalidException{
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
                        throw new RepetedException();
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
