package MainComplementary;

import com.API;
import com.Resource;
import com.User;

import java.util.ArrayList;
import java.util.Scanner;

public class mainMenu2 {
    public static void main_login(String[] args) {

        API api = new API();
        Scanner myObj = new Scanner(System.in);
        String email;
        String password;

        System.out.println("\nEnter Email:");
        email = myObj.nextLine();
        System.out.println("  Enter Password:");
        password = myObj.nextLine();

        api.loginUser(email, password);
    }

    public static void main_CreateUser_WithoutLogin(String[] args) {

        API api = new API();
        Scanner myObj = new Scanner(System.in);
        String name;
        String job;

        System.out.println("\nEnter name:");
        name = myObj.nextLine();
        System.out.println("Enter job:");
        job = myObj.nextLine();
        System.out.println("\n");

        api.createUser(name, job);

    }

    public static void main_Registry_WithouLogin(String[] args) {

        API api = new API();
        Scanner myObj = new Scanner(System.in);
        String email;
        String password;

        System.out.println("\nEnter Email:");
        email = myObj.nextLine();
        System.out.println("Enter Password:");
        password = myObj.nextLine();

        api.registryuser(email, password);

    }

    public static void main_ListUsers_WithoutLogin(String[] args) {

        API api = new API();
        ArrayList<User> users_list = api.listingUsers();

    }

    public static void main_ListResources_WithoutLogin(String[] args) {

        API api = new API();
        ArrayList<Resource> resources_list = api.listingResources();

    }

    public static void main_SearchUser_WithoutLogin(String[] args) {

        API api = new API();
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter ID from User:");
        int id = myObj.nextInt();

        User searchUser = api.consultingUser(id);

    }

    public static void main_SearchResources_WithoutLogin(String[] args) {

        API api = new API();
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter ID from Resource:");
        int id = myObj.nextInt();

        Resource searchResource = api.consultingResource(id);
    }
}
