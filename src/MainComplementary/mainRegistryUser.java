package MainComplementary;

import com.Registry;
import com.controllerApp;

import java.util.Scanner;

public class mainRegistryUser {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Scanner myObj = new Scanner(System.in);

        String email;
        String password;

        System.out.println("\nEnter Email:");
        email = myObj.nextLine();
        System.out.println("Enter Password:");
        password = myObj.nextLine();

        Registry user = containerapp.registryuser(email, password, admin, token);

    }


}
