package MainComplementary;

import com.Registry;
import com.User;
import com.controllerApp;

import java.sql.Timestamp;
import java.util.Scanner;


public class mainCreateUser {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Scanner myObj = new Scanner(System.in);

        String name;
        String job;

        System.out.println("\nEnter name:");
        name = myObj.nextLine();
        System.out.println("Enter job:");
        job = myObj.nextLine();

        containerapp.createUser(name, job, admin, token);

    }

}
