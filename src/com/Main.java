package com;
import java.io.IOException;
import java.util.Scanner;
import MainComplementary.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int opcao = 0;
        Scanner myObj = new Scanner(System.in);
        do {

            System.out.println("\n                  ======= Menu Aplication =======");
            System.out.println("                  |     1 - Create User         |");
            System.out.println("                  |     2 - Register User       |");
            System.out.println("                  |     3 - Login User          |");
            System.out.println("                  |     4 - List Users          |");
            System.out.println("                  |     5 - List Resource       |");
            System.out.println("                  |     6 - Search User         |");
            System.out.println("                  |     7 - Search Resource     |");
            System.out.println("                  |     0 - Close               |");
            System.out.println("                  ===============================\n");

            System.out.print("\n Option: \t");
            opcao = myObj.nextInt();

            switch (opcao) {
                case 1:
                    mainCreateUser.main(args);
                    break;
                case 2:
                    mainRegistryUser.main(args);
                    break;
                case 3:
                    mainLogin.main(args);
                    break;
                case 4:
                    mainListUsers.main(args);
                    break;
                case 5:
                    mainListResources.main(args);
                    break;
                case 6:
                    mainUserDetail.main(args);
                    break;
                case 7:
                    mainResourceDetail.main(args);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        } while (opcao != 0);

    }
}




















































































// CODIGO ANTIGO
//System.out.println("Hello WORLD");
//System.out.println(MateRequest.executeGet("https://reqres.in/api/users?page=2"));

//User.printListUsers(API.listUsers());
//System.out.println(API.userDetails(5).toString());
//Resource.printListResources(API.listResources());
//System.out.println(API.resourceDetails(2).toString());
// System.out.println(API.login("eve.holt@redadasfeafs.in", "1"));
//System.out.println(API.login("eve.holt@reqres.in", "cityslicka"));
// System.out.println(API.delayPublicUsers());

//System.out.println(API.register("eve.holt@reqres.in", "pistol"));

//System.out.println(API.createUser(new User(2,"morpheus","joao","","")));



/*APP SEM A API*/

//CRIAR UTILIZADOR
//Stub stub = new Stub();
//stub.createUser("Jorge", "Trolha");

//LISTAR UTILIZADOR //
//stub.listUser(203);

//LISTAR TODOS OS UTILIZADORES
//stub.listAllUsers();

//REGISTAR UM UTILIZADOR DE MODO A ACEDER À APP
//stub.accessUserToApp("jorge@gmail.com", null);
//stub.accessUserToApp("jorge@gmail.com", "123");

//LOGIN DE UM UTILIZADOR
//stub.loginUser("andre@gmail.com", "user3");

//LISTAR UM RECURSO
//stub.listResource(200);

//LISTAR TODOS OS RECURSOS
//stub.listAllResources();