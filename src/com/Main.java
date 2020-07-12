package com;
import java.io.IOException;
import java.util.Scanner;
import MainComplementary.*;
public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        Scanner myObj = new Scanner(System.in);
        do {

            System.out.println("\n                  ============ Menu Aplication =============");
            System.out.println("                  |     1 - Create User                    |");
            System.out.println("                  |     2 - Register User                  |");
            System.out.println("                  |     3 - Login User                     |");
            System.out.println("                  |     4 - List Users                     |");
            System.out.println("                  |     5 - List Resource                  |");
            System.out.println("                  |     6 - Search User                    |");
            System.out.println("                  |     7 - Search Resource                |");
            System.out.println("                  |     8 - Functionalities Without Login  |");
            System.out.println("                  |     0 - Close                          |");
            System.out.println("                  ==========================================\n");

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
                case 8:
                    main2(args);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        } while (opcao != 0);

    }

    public static void main2(String[] args) {
        int opcao = 0;
        Scanner myObj = new Scanner(System.in);
        do {

            System.out.println("\n                  ========== Menu 2 Aplication ===========");
            System.out.println("                  |     1 - Login User                     |");
            System.out.println("                  |     2 - Create User Without Login      |");
            System.out.println("                  |     3 - Register User Without Login    |");
            System.out.println("                  |     4 - List Users Without Login       |");
            System.out.println("                  |     5 - List Resource Without Login    |");
            System.out.println("                  |     6 - Search User Without Login      |");
            System.out.println("                  |     7 - Search Resource Without Login  |");
            System.out.println("                  |     0 - Back    <--------------------  |");
            System.out.println("                  ==========================================\n");

            System.out.print("\n Option: \t");
            opcao = myObj.nextInt();

            switch (opcao) {
                case 1:
                    mainMenu2.main_login(args);
                    break;
                case 2:
                    mainMenu2.main_CreateUser_WithoutLogin(args);
                    break;
                case 3:
                    mainMenu2.main_Registry_WithouLogin(args);
                    break;
                case 4:
                    mainMenu2.main_ListUsers_WithoutLogin(args);
                    break;
                case 5:
                    mainMenu2.main_ListResources_WithoutLogin(args);
                    break;
                case 6:
                    mainMenu2.main_SearchUser_WithoutLogin(args);
                    break;
                case 7:
                    mainMenu2.main_SearchResources_WithoutLogin(args);
                    break;
                case 0:
                    main(args);
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        } while (opcao != 0);

    }
}
