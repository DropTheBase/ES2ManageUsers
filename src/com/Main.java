package com;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello WORLD");
        //System.out.println(MateRequest.executeGet("https://reqres.in/api/users?page=2"));

        User.printListUsers(API.listUsers());
        System.out.println(API.userDetails(2).toString());
        Resource.printListResources(API.listResources());
        System.out.println(API.resourceDetails(2).toString());
        System.out.println(API.login("eve.holt@redadasfeafs.in", "1"));
        System.out.println(API.login("eve.holt@reqres.in", "cityslicka"));
        System.out.println(API.createUser(new User(2,"morpheus","joao","","")));

    }
}
