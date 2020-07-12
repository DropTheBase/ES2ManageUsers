package MainComplementary;

import com.controllerApp;

import java.util.Scanner;

public class mainLogin {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        Scanner myObj = new Scanner(System.in);
        String email;
        String password;

        System.out.println("\nEnter Email:");
        email = myObj.nextLine();
        System.out.println("Enter Password:");
        password = myObj.nextLine();

        containerapp.loginUser(email, password);
    }
}
