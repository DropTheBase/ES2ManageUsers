package com;
import java.io.IOException;
import java.util.Scanner;
import MainComplementary.*;
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
